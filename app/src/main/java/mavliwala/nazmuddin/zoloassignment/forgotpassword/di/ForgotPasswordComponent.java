package mavliwala.nazmuddin.zoloassignment.forgotpassword.di;

import dagger.Subcomponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Subcomponent(modules = ForgotPasswordModule.class)
public interface ForgotPasswordComponent {
    void inject(ForgotPasswordActivity activity);
}
