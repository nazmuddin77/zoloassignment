package mavliwala.nazmuddin.zoloassignment.forgotpassword.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.di.ForgotPasswordModule;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters.ForgotPasswordPresenter;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

import static mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity.USER;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class ForgotPasswordActivity extends BaseActivity implements ForgotPasswordView {

    @BindView(R.id.et_email)
    EditText etEmail;
    private UserVO userVO;

    @Inject
    ForgotPasswordPresenter presenter;

    @OnClick(R.id.bt_update)
    public void onUpdateClick() {
        this.presenter.validate(getValue(R.id.et_email));
    }

    @OnClick(R.id.bt_login)
    public void onLoginClick() {
        this.navigator.navigate(LoginActivity.class);
        finish();
    }

    private UserVO getUserVO(String newPassword) {
        if (this.userVO != null) {
            this.userVO.setPassword(newPassword);
        }
        return this.userVO;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideForgotPasswordComponent(new ForgotPasswordModule(this))
                .inject(this);
        userVO = Parcels.unwrap(getIntent().getParcelableExtra(USER));
        etEmail.setText(userVO.getEmail());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public void emailUpdatedPassword(final String password) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",getValue(R.id.et_email), null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Updated Password");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "new password = " + password);
        startActivity(emailIntent);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onSuccessFullValidation() {
        String newPassword = getNewPassword();
        UserVO userVO = getUserVO(newPassword);
        this.presenter.updatePassword(userVO);
    }

    private String getNewPassword() {
        return "1234567";
    }
}
