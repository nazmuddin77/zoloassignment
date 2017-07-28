package mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.forgotpassword.ForgotPasswordUseCase;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordView;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordView> {

    private final ForgotPasswordUseCase useCase;

    @Inject
    public ForgotPasswordPresenter(ForgotPasswordView view, ForgotPasswordUseCase useCase) {
        super(view);
        this.useCase = useCase;
    }

    public void validate(String email) {

    }

    public void authenticate(String email) {
        this.useCase.authenticate(email, new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {

            }
        });
    }
}
