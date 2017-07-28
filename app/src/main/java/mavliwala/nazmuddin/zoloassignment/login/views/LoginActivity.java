package mavliwala.nazmuddin.zoloassignment.login.views;

import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.OnClick;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordActivity;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class LoginActivity extends BaseActivity {

    @BindViews({
            R.id.bt_login,
            R.id.bt_forgot_password
    })
    List<Button> buttons;

    @OnClick(R.id.bt_login)
    public void onLoginClick() {

    }

    @OnClick(R.id.bt_forgot_password)
    public void onForgotPasswordClick() {
        this.navigator.navigate(ForgotPasswordActivity.class);
    }

    @OnClick(R.id.bt_register)
    public void onRegisterClick() {
        this.navigator.navigate(RegisterActivity.class);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}
