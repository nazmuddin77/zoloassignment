package mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.forgotpassword.ForgotPasswordUseCase;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordView> {

    private final ForgotPasswordUseCase useCase;
    private final UserVOToUserConverter converter;

    @Inject
    public ForgotPasswordPresenter(ForgotPasswordView view,
                                   ForgotPasswordUseCase useCase,
                                   UserVOToUserConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void validate(String email) {

    }

    public void updatePassword(UserVO userVO) {
        User user = this.converter.convert(userVO);
        view.showLoading();
        this.useCase.updatePassword(user, new Subscriber<User>() {
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
                view.emailUpdatedPassword(user.getPassword());
            }
        });
    }

}
