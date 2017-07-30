package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.profile.ProfileUseCase;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileView;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class ProfilePresenter extends BasePresenter<ProfileView> {

    private final ProfileUseCase useCase;
    private final UserToUserVOConverter converter;

    @Inject
    public ProfilePresenter(ProfileView view,
                            ProfileUseCase useCase,
                            UserToUserVOConverter converter) {
        super(view);
        this.useCase = useCase;
        this.converter = converter;
    }

    public void getUser(Long userId) {
        this.view.showLoading();
        this.useCase.getUser(userId, new Action1<User>() {
            @Override
            public void call(User user) {
                view.hideLoading();
                view.bind(converter.convert(user));
            }
        });
    }

    public void logout() {
        this.useCase.logout();
    }
}
