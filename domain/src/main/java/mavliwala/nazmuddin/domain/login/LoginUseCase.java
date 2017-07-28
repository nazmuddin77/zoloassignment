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

    public void login(final String mobile, final String password, Subscriber<Boolean> subscriber) {
        //check if the mobile number already exists, if yes then proceed else throw error.
        this.repository.recognizeUser(mobile)
                .switchMap(new Func1<List<User>, Observable<Response>>() {
                    @Override
                    public Observable<Response> call(List<User> users) {
                        if (users.size() == 0) return Observable.error(UserNotFoundException.createInstance());
                        return repository.login(mobile,password);
                    }
                })
                //validate credentials
                .switchMap(new Func1<Response, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Response response) {
                        if (response instanceof Response.Success) return Observable.just(true);
                        else return Observable.error(new InvalidCredentialsException());
                    }
                })
                .subscribe(subscriber);
    }
}
