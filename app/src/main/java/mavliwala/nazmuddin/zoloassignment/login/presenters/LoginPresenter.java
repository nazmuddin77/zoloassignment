package mavliwala.nazmuddin.zoloassignment.login.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.LoginUseCase;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;
import mavliwala.nazmuddin.zoloassignment.utils.ErrorMessageFactory;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

@ChildActivity
public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginUseCase useCase;
    private final UserToUserVOConverter converter;

    @Inject
    public LoginPresenter(LoginView view,
                          LoginUseCase useCase,
                          UserToUserVOConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void validate(String mobile, String password) {
        boolean valis = false;
        if (mobile == null || mobile.isEmpty()) {
            view.showError(getString(R.string.empty_mobile_error));
        }

    }

    public void login(String mobile, String password) {
        this.view.showLoading();
        this.useCase.login(mobile, password, new Subscriber<User>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.showError(ErrorMessageFactory.create(e));
            }

            @Override
            public void onNext(User user) {
                view.hideLoading();
                view.navigateToProfileActivity(converter.convert(user));
            }
        });
    }

    public void recognizeMobile(String mobile) {
        this.view.showLoading();
        this.useCase.recognizeMobile(mobile, new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
            }

            @Override
            public void onNext(User user) {
                view.hideLoading();
                view.navigateToForgotPasswordActivity(converter.convert(user));
            }
        });
    }
}
