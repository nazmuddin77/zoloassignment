package mavliwala.nazmuddin.zoloassignment.register.di;

import dagger.Subcomponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Subcomponent(modules = RegisterModule.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}
