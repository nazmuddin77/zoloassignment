package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Module;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Module
public class EditProfileModule {

    private final EditProfileActivity activity;

    public EditProfileModule(EditProfileActivity activity) {
        this.activity = activity;
    }
}
