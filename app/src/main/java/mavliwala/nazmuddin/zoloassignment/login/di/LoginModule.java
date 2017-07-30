package mavliwala.nazmuddin.zoloassignment.login.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.LoginDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityToUserConverter;
import mavliwala.nazmuddin.domain.login.LoginRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

@ChildActivity
@Module
public class LoginModule {

    private final LoginActivity activity;

    public LoginModule(LoginActivity activity) {
        this.activity = activity;
    }


    @ChildActivity
    @Provides
    public UserEntityToUserConverter provideConverter() {
        return new UserEntityToUserConverter();
    }

    @ChildActivity
    @Provides
    public LoginRepository provideRepo(LoginDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    public LoginView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public UserToUserVOConverter provideDomainToViewConverter() {
        return new UserToUserVOConverter();
    }
}
