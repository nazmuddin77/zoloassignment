package mavliwala.nazmuddin.domain.profile;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;

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
}
