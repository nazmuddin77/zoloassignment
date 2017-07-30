package mavliwala.nazmuddin.zoloassignment.register.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.register.RegisterUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterView;
import mavliwala.nazmuddin.zoloassignment.utils.ErrorMessageFactory;
import mavliwala.nazmuddin.zoloassignment.utils.ValidationUtils;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class RegisterPresenter extends BasePresenter<RegisterView> {

    private final RegisterUseCase useCase;
    private final UserVOToUserConverter converter;
    private final UserToUserVOConverter userVOConverter;

    @Inject
    public RegisterPresenter(RegisterView view,
                             RegisterUseCase useCase,
                             UserVOToUserConverter converter,
                             UserToUserVOConverter userVOConverter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
        this.userVOConverter = userVOConverter;
    }

    public void validate(UserVO userVO) {
        //validateLogin mobile
        String mobile = userVO.getMobile();
        if (mobile == null || mobile.isEmpty()) {
            view.showError(getString(R.string.empty_mobile_error));
            return;
        }
        if (!ValidationUtils.isValidMobile(mobile)) {
            view.showError(getString(R.string.invalid_mobile_error));
            return;
        }

        //validateLogin email
        String email = userVO.getEmail();
        if (email == null || email.isEmpty()) {
            view.showError(getString(R.string.empty_email_error));
            return;
        }
        if (!ValidationUtils.isValidEmail(email)) {
            view.showError(getString(R.string.invalid_email_error));
            return;
        }

        //validateLogin name
        String name = userVO.getName();
        if (name == null || name.isEmpty()) {
            view.showError(getString(R.string.empty_name_error));
            return;
        }
        if (!ValidationUtils.isValidName(name)) {
            view.showError(getString(R.string.invalid_name_error));
            return;
        }

        String password = userVO.getPassword();
        if (password == null || password.isEmpty()) {
            view.showError(getString(R.string.empty_password_error));
            return;
        }
        if (!ValidationUtils.isValidPassword(password)) {
            view.showError(getString(R.string.invalid_password_error));
            return;
        }
        view.onSuccessFullValidation(userVO);
    }

    public void register(final UserVO userVO) {
        view.showLoading();
        User user = this.converter.convert(userVO);
        this.useCase.register(user, new Subscriber<Boolean>() {
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
                view.navigateToLogin(userVO);
            }
        });
    }

    public void getTrueProfile() {
        this.view.showLoading();
        this.useCase.fetchTrueProfile(new Action1<User>() {
            @Override
            public void call(User user) {
                view.hideLoading();
                view.bind(userVOConverter.convert(user));
            }
        });
    }
}
