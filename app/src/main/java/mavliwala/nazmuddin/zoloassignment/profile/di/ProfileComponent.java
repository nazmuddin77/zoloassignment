package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Subcomponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

@ChildActivity
@Subcomponent(modules = ProfileModule.class)
public interface ProfileComponent {
    void inject(ProfileActivity activity);
}
