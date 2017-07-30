package mavliwala.nazmuddin.zoloassignment.forgotpassword.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.ForgotPasswordDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityToUserConverter;
import mavliwala.nazmuddin.data.repositories.UserToEntityConverter;
import mavliwala.nazmuddin.domain.forgotpassword.ForgotPasswordRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordView;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Module
public class ForgotPasswordModule {

    private final ForgotPasswordActivity activity;

    public ForgotPasswordModule(ForgotPasswordActivity activity) {
        this.activity = activity;
    }

    @ChildActivity
    @Provides
    public ForgotPasswordView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public ForgotPasswordRepository provideRepo(ForgotPasswordDataRepository repository) {
        return repository;
    }


    @ChildActivity
    @Provides
    public UserVOToUserConverter providePresentationToDomainConverter() {
        return new UserVOToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserEntityToUserConverter provideDataToDomainConverter() {
        return new UserEntityToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserToEntityConverter provideDomainToDataConverter() {
        return new UserToEntityConverter();
    }

    @ChildActivity
    @Provides
    public UserToUserVOConverter provideConverter(){
        return new UserToUserVOConverter();
    }


}
