package mavliwala.nazmuddin.zoloassignment.login.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.hendraanggrian.rx.activity.ActivityResult;
import com.hendraanggrian.rx.activity.RxActivity;
import com.jakewharton.rxbinding2.view.RxView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.OnClick;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.login.di.LoginModule;
import mavliwala.nazmuddin.zoloassignment.login.presenters.LoginPresenter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;

import static mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity.USER;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindViews({
            R.id.bt_login,
            R.id.bt_forgot_password,
            R.id.bt_register
    })
    List<Button> buttons;

    @OnClick(R.id.bt_login)
    public void onLoginClick() {
        this.presenter.login("9893887832","12345");
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
        bindRegisterClick();
    }

    private void bindRegisterClick() {
        RxView.clicks(finView(R.id.bt_register))
                .switchMap(new Function<Object, ObservableSource<ActivityResult>>() {
                    @Override
                    public ObservableSource<ActivityResult> apply(@NonNull Object o) throws Exception {
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        return RxActivity.startForResult(LoginActivity.this,intent);
                    }
                })
                .filter(new Predicate<ActivityResult>() {
                    @Override
                    public boolean test(@NonNull ActivityResult result) throws Exception {
                        return result.resultCode == RESULT_OK;
                    }
                })
                .map(new Function<ActivityResult, UserVO>() {
                    @Override
                    public UserVO apply(@NonNull ActivityResult result) throws Exception {
                        Intent intent = result.data;
                        return Parcels.unwrap(intent.getParcelableExtra(USER));
                    }
                })
                .subscribe(new Consumer<UserVO>() {
                    @Override
                    public void accept(@NonNull UserVO userVO) throws Exception {
                        String mobile = userVO.getMobile();
                        String password = userVO.getPassword();
                        presenter.login(mobile,password);

                    }
                });
    }
}
