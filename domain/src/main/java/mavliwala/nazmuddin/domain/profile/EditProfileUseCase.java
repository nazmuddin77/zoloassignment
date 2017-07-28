package mavliwala.nazmuddin.domain.profile;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.UseCase;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class EditProfileUseCase extends UseCase<EditProfileRepository> {

    @Inject
    public EditProfileUseCase(ExecutionThread executionThread,
                              PostExecutionThread postExecutionThread,
                              EditProfileRepository repository) {
        super(executionThread, postExecutionThread, repository);
    }
}
