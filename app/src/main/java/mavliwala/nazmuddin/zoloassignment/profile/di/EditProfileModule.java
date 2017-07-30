package mavliwala.nazmuddin.zoloassignment.profile.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.EditProfileDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityToUserConverter;
import mavliwala.nazmuddin.data.repositories.UserToEntityConverter;
import mavliwala.nazmuddin.domain.profile.EditProfileRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.UserToUserVOConverter;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.EditProfileView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;

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

    @ChildActivity
    @Provides
    public EditProfileView provideView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public EditProfileRepository provideRepo(EditProfileDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    public UserVOToUserConverter provideConverter() {
        return new UserVOToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserToUserVOConverter provideConverter1() {
        return new UserToUserVOConverter();
    }

    @ChildActivity
    @Provides
    public UserToEntityConverter provideConverter2() {
        return new UserToEntityConverter();
    }

    @ChildActivity
    @Provides
    public UserEntityToUserConverter provideConverter4() {
        return new UserEntityToUserConverter();
    }

}
