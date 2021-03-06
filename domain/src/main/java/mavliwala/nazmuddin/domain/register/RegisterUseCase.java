package mavliwala.nazmuddin.domain.register;

import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import mavliwala.nazmuddin.domain.forgotpassword.UnhandledException;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class RegisterUseCase extends UseCase<RegisterRepository> {

    @Inject
    public RegisterUseCase(ExecutionThread executionThread,
                           PostExecutionThread postExecutionThread,
                           RegisterRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void register(final User user, Subscriber<Boolean> subscriber) {
        //check if mobile already exists
        this.repository.getUserWithMobile(user.getMobile())
                .compose(this.<List<User>>applySchedulers())
                .switchMap(new Func1<List<User>, Observable<List<User>>>() {
                    @Override
                    public Observable<List<User>> call(List<User> users) {
                        //if mobile number already exists, raise exception
                        //else check if email already exists/
                        if (users == null || users.size() == 0)
                            return repository.getUserWithEmail(user.getEmail())
                                    .compose(RegisterUseCase.this.<List<User>>applySchedulers());
                        return Observable.error(UserWithMobileAlreadyExistException.createInstance());
                    }
                })
                .switchMap(new Func1<List<User>, Observable<Response<User>>>() {
                    @Override
                    public Observable<Response<User>> call(List<User> users) {
                        if (users == null || users.size() == 0)
                            //if email already exists raise exception, else register
                            return repository.register(user)
                            .compose(RegisterUseCase.this.<Response<User>>applySchedulers());
                        return Observable.error(UserWithEmailAlreadyExistsException.createInstance());
                    }
                })
                .switchMap(new Func1<Response<User>, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Response<User> response) {
                        //if registration is successfull return true, else return
                        // IllegalStateException
                        if (response.isSuccessFull()) return Observable.just(true);
                        else return Observable.error(UnhandledException.createInstance());
                    }
                })
                .subscribe(subscriber);
    }

    public void fetchTrueProfile(Action1<User> action1) {
        User user = new User.UserBuilder()
                .setEmail("nazma@gmail.com")
                .setMobile("9892887843")
                .setName("Nazmuddin Mavliwala")
                .createUser();
        Observable.just(user)
                .compose(this.<User>applySchedulers())
                .subscribe(action1);
    }
}
