package mavliwala.nazmuddin.zoloassignment.forgotpassword.views;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.di.ForgotPasswordModule;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters.ForgotPasswordPresenter;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class ForgotPasswordActivity extends BaseActivity {

    @Inject
    ForgotPasswordPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideForgotPasswordComponent(new ForgotPasswordModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forgot_password;
    }
}
