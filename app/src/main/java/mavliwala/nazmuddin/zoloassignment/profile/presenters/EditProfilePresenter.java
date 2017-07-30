package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.profile.EditProfileUseCase;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
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
