package mavliwala.nazmuddin.zoloassignment.login.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Button;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.OnClick;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordActivity;
import mavliwala.nazmuddin.zoloassignment.login.di.LoginModule;
import mavliwala.nazmuddin.zoloassignment.login.presenters.LoginPresenter;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideLoginComponent(new LoginModule(this))
                .inject(this);
    }

    @Override
    public void showError(@StringRes int resId) {
    }
}
