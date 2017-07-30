package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.profile.EditProfileUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
import mavliwala.nazmuddin.zoloassignment.utils.ValidationUtils;
import rx.Subscriber;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class EditProfilePresenter extends BasePresenter<EditProfileView> {

    private final EditProfileUseCase useCase;
    private final UserVOToUserConverter converter;
    private final UserToUserVOConverter userToUserVOConverter;

    @Inject
    public EditProfilePresenter(EditProfileView view,
                                EditProfileUseCase useCase,
                                UserVOToUserConverter converter,
                                UserToUserVOConverter userToUserVOConverter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
        this.userToUserVOConverter = userToUserVOConverter;
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
        view.onSuccessFullValidation(userVO);
    }

    public void update(UserVO userVO) {
        User user = this.converter.convert(userVO);
        this.view.showLoading();
        this.useCase.update(user, new Subscriber<User>() {
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
                view.returnUpdatedProfile(userToUserVOConverter.convert(user));
            }
        });
    }
}
