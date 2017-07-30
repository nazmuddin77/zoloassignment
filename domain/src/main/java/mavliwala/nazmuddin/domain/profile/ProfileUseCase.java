package mavliwala.nazmuddin.domain.profile;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class ProfileUseCase extends UseCase<ProfileRepository>{

    @Inject
    public ProfileUseCase(ExecutionThread executionThread,
                          PostExecutionThread postExecutionThread,
                          ProfileRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }

    public void getUser(Long userId, Action1<User> action1) {
        this.repository.getUser(userId)
                .compose(this.<User>applySchedulers())
                .subscribe(action1);
    }
}
