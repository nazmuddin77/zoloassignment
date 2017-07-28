package mavliwala.nazmuddin.zoloassignment.register.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.register.RegisterUseCase;
import mavliwala.nazmuddin.domain.register.UserWithEmailAleradyExistsException;
import mavliwala.nazmuddin.domain.register.UserWithMobileAlreadyExistException;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterView;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class RegisterPresenter extends BasePresenter<RegisterView> {

    private final RegisterUseCase useCase;
    private final UserVOToUserConverter converter;

    @Inject
    public RegisterPresenter(RegisterView view,
                             RegisterUseCase useCase,
                             UserVOToUserConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void Validate(UserVO userVO) {

    }

    public void register(UserVO userVO) {
        User user = this.converter.convert(userVO);
        this.useCase.register(user, new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                if (e instanceof UserWithMobileAlreadyExistException)
                    view.showError(R.string.mobile_already_exists_error);
                else if (e instanceof UserWithEmailAleradyExistsException)
                    view.showError(R.string.email_already_exists_error);
                else view.showError(R.string.something_went_wrong);

            }

            @Override
            public void onNext(Boolean aBoolean) {

            }
        });
    }
}
