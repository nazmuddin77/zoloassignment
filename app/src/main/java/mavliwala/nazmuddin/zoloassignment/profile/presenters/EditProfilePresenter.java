package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import javax.inject.Inject;

import mavliwala.nazmuddin.domain.profile.EditProfileUseCase;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BasePresenter;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileView;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
public class EditProfilePresenter extends BasePresenter<EditProfileView> {

    private final EditProfileUseCase useCase;

    @Inject
    public EditProfilePresenter(EditProfileView view, EditProfileUseCase useCase) {
        super(view);
        this.useCase = useCase;
    }
}
