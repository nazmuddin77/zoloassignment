package mavliwala.nazmuddin.zoloassignment.login.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.LoginDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityConverter;
import mavliwala.nazmuddin.domain.login.LoginRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;

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
    public UserEntityConverter provideConverter() {
        return new UserEntityConverter();
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
}
