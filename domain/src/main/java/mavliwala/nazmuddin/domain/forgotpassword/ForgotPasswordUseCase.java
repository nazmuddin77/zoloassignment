package mavliwala.nazmuddin.domain.forgotpassword;

import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import mavliwala.nazmuddin.domain.login.UserNotFoundException;
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

    public void authenticate(String email, Subscriber<Boolean> subscriber) {
        this.repository.getUserWithEmail()
                .compose(this.<List<User>>applySchedulers())
                .switchMap(new Func1<List<User>, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(List<User> users) {
                        if (users == null || users.size() == 0)
                            return Observable.error(UserNotFoundException.createInstance());
                        return Observable.just(true);
                    }
                });
    }
}
