package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.profile.ProfileUseCase;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileView;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class ProfilePresenter extends BasePresenter<ProfileView> {

    private final ProfileUseCase useCase;

    @Inject
    public ProfilePresenter(ProfileView view, ProfileUseCase useCase) {
        super(view);
        this.useCase = useCase;
    }
}
