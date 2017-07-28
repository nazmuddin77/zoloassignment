package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Module;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileActivity;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */


@ChildActivity
@Module
public class ProfileModule {

    private final ProfileActivity activity;

    public ProfileModule(ProfileActivity activity) {
        this.activity = activity;
    }
}
