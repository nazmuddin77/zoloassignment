package mavliwala.nazmuddin.zoloassignment.forgotpassword.di;

import dagger.Module;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordActivity;

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


}
