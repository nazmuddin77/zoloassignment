package mavliwala.nazmuddin.zoloassignment.login.di;

import dagger.Subcomponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */


@ChildActivity
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
