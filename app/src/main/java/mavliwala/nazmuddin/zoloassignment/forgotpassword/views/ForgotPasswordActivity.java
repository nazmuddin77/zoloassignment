package mavliwala.nazmuddin.zoloassignment.forgotpassword.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.hendraanggrian.rx.activity.ActivityResult;
import com.hendraanggrian.rx.activity.RxActivity;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.di.ForgotPasswordModule;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters.ForgotPasswordPresenter;
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
        String newPassword = getNewPassword();
        this.presenter.updatePassword(getUserVO(newPassword));

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
        Observable.just(password)
                .map(new Function<String, Intent>() {
                    @Override
                    public Intent apply(@NonNull String s) throws Exception {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto",getValue(R.id.et_email), null));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Updated Password");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "new password = " + password);
                        return emailIntent;
                    }
                })
                .switchMap(new Function<Intent, ObservableSource<ActivityResult>>() {
                    @Override
                    public ObservableSource<ActivityResult> apply(@NonNull Intent intent) throws Exception {
                        return RxActivity.startForResult(ForgotPasswordActivity.this,intent);
                    }
                })
                .filter(new Predicate<ActivityResult>() {
                    @Override
                    public boolean test(@NonNull ActivityResult result) throws Exception {
                        return result.resultCode == RESULT_OK;
                    }
                })
                .subscribe(new Consumer<ActivityResult>() {
                    @Override
                    public void accept(@NonNull ActivityResult result) throws Exception {
                        setResult(RESULT_OK);
                        finish();
                    }
                });
    }

    private String getNewPassword() {
        return "1234567";
    }
}
