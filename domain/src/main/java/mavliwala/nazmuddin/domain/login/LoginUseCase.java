package mavliwala.nazmuddin.domain.login;

import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */


public class LoginUseCase extends UseCase<LoginRepository> {

    @Inject
    public LoginUseCase(ExecutionThread executionThread,
                        PostExecutionThread postExecutionThread,
                        LoginRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void login(final String mobile, final String password, Subscriber<User> subscriber) {
        //check if the mobile number already exists, if yes then proceed else throw error.
        this.repository.recognizeUser(mobile)
                .compose(this.<List<User>>applySchedulers())
                .switchMap(new Func1<List<User>, Observable<Response<User>>>() {
                    @Override
                    public Observable<Response<User>> call(List<User> users) {
                        if (users.size() == 0)
                            return Observable.error(UserNotFoundException.createInstance());
                        return repository.login(mobile,password)
                                .compose(LoginUseCase.this.<Response<User>>applySchedulers());
                    }
                })
                //validate credentials
                .switchMap(new Func1<Response<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(Response<User> response) {
                        if (response.isSuccessFull()) {
                            User user = response.getResponseBody();
                            return Observable.just(user);
                        }
                        return Observable.error(new InvalidCredentialsException());
                    }
                })
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        repository.setLogin(true);
                        repository.setActiveProfile(user.getId());
                    }
                })
                .subscribe(subscriber);
    }

    public void recognizeMobile(String mobile, Subscriber<User> subscriber) {
        this.repository.recognizeUser(mobile)
                .compose(this.<List<User>>applySchedulers())
                .switchMap(new Func1<List<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(List<User> users) {
                        if (users != null && users.size() > 0) {
                            return Observable.just(users.get(0));
                        }
                        return Observable.error(UserNotFoundException.createInstance());
                    }
                })
                .subscribe(subscriber);
    }
}
