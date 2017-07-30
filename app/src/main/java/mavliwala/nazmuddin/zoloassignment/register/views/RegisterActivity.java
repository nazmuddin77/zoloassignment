package mavliwala.nazmuddin.zoloassignment.register.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.OnClick;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;
import mavliwala.nazmuddin.zoloassignment.register.di.RegisterModule;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.presenters.RegisterPresenter;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class RegisterActivity extends BaseActivity implements RegisterView {

    public static final String USER = "user";

    @Inject
    RegisterPresenter presenter;

    @BindViews({
            R.id.et_mobile,
            R.id.et_email,
            R.id.et_name,
            R.id.et_password,
            R.id.et_referral_code
    })
    List<EditText> editTexts;

    @OnClick(R.id.bt_register)
    public void onRegisterClick() {
        this.presenter.validate(constructUser());
    }

    @OnClick(R.id.bt_truecaller)
    public void onTrueCallerClick() {
        this.presenter.getTrueProfile();
    }


    @OnClick(R.id.bt_login)
    public void onLoginClick() {
        this.navigator.navigate(LoginActivity.class);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideRegisterComponent(new RegisterModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    private UserVO constructUser() {
        return new UserVO.UserVOBuilder()
                .setMobile(getValue(R.id.et_mobile))
                .setEmail(getValue(R.id.et_email))
                .setName(getValue(R.id.et_name))
                .setPassword(getValue(R.id.et_password))
                .setReferralCode(getValue(R.id.et_referral_code))
                .createUserVO();
    }

    @Override
    public void navigateToLogin(UserVO userVO) {
        Intent intent = getIntent();
        intent.putExtra(USER, Parcels.wrap(userVO));
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onSuccessFullValidation(UserVO userVO) {
        this.presenter.register(userVO);
    }

    @Override
    public void bind(UserVO userVO) {
        if (userVO != null) {
            EditText etName = finView(R.id.et_name);
            etName.setText(userVO.getName());

            EditText etEmail = finView(R.id.et_email);
            etEmail.setText(userVO.getEmail());

            EditText etMobile = finView(R.id.et_mobile);
            etMobile.setText(userVO.getMobile());
        }
    }
}
