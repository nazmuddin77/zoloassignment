package mavliwala.nazmuddin.domain.forgotpassword;

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
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class ForgotPasswordUseCase extends UseCase<ForgotPasswordRepository> {

    @Inject
    public ForgotPasswordUseCase(ExecutionThread executionThread,
                                 PostExecutionThread postExecutionThread,
                                 ForgotPasswordRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void updatePassword(User user, Subscriber<User> subscriber) {
        this.repository.update(user)
                .compose(this.<Response<User>>applySchedulers())
                .switchMap(new Func1<Response<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(Response<User> response) {
                        if (response.isSuccessFull()) {
                            User user1 = response.getResponseBody();
                            return Observable.just(user1);
                        }
                        return Observable.error(UnhandledException.createInstance());
                    }
                })
                .subscribe(subscriber);
    }
}
