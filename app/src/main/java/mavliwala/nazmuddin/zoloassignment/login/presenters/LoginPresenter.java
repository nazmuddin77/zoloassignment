package mavliwala.nazmuddin.zoloassignment.login.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.LoginUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;
import mavliwala.nazmuddin.zoloassignment.utils.ErrorMessageFactory;
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
            view.showError(getString(R.string.empty_mobile_error));
        }

    }

    public void login(String mobile, String password) {
        this.view.showLoading();
        this.useCase.login(mobile, password, new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.hideLoading();
                view.showError(ErrorMessageFactory.create(e));
            }

            @Override
            public void onNext(Boolean aBoolean) {
                view.hideLoading();
            }
        });
    }
}
