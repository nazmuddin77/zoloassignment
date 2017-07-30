package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Subcomponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Subcomponent(modules = EditProfileModule.class)
public interface EditProfileComponent {
    void inject(EditProfileActivity activity);
}
