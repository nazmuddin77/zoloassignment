package mavliwala.nazmuddin.zoloassignment.register.di;

import dagger.Module;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */


@ChildActivity
@Module
public class RegisterModule {

    private final RegisterActivity activity;

    public RegisterModule(RegisterActivity activity) {
        this.activity = activity;
    }
}
