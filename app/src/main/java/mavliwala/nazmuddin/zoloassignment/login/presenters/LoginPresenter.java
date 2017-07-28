package mavliwala.nazmuddin.zoloassignment.login.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.InvalidCredentialsException;
import mavliwala.nazmuddin.domain.login.LoginUseCase;
import mavliwala.nazmuddin.domain.login.UserNotFoundException;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

@ChildActivity
public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginUseCase useCase;

    @Inject
    public LoginPresenter(LoginView view, LoginUseCase useCase) {
        super(view);
        this.useCase = useCase;
    }

    public void validate(String mobile, String password) {
        boolean valis = false;
        if (mobile == null || mobile.isEmpty()) {
            view.showError(R.string.empty_mobile_error);
        }

    }

    public void login(String mobile, String password) {
        this.useCase.login(mobile, password, new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                if (e instanceof UserNotFoundException) view.showError(R.string.user_not_found_error);
                else if (e instanceof InvalidCredentialsException) view.showError(R.string.invalid_credentials_error);
                else view.showError(R.string.something_went_wrong);
            }

            @Override
            public void onNext(Boolean aBoolean) {

            }
        });
    }
}
