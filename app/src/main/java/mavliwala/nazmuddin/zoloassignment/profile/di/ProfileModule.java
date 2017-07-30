package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.ProfileDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityToUserConverter;
import mavliwala.nazmuddin.domain.profile.ProfileRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileView;

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

    @ChildActivity
    @Provides
    public ProfileView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public ProfileRepository provideRepo(ProfileDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    public UserEntityToUserConverter provideEntityToDomainConverter() {
        return new UserEntityToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserToUserVOConverter provideDomainToViewConverter() {
        return new UserToUserVOConverter();
    }
}
