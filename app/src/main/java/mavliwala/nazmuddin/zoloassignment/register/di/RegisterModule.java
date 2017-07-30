package mavliwala.nazmuddin.zoloassignment.register.di;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.repositories.RegisterDataRepository;
import mavliwala.nazmuddin.data.repositories.UserEntityToUserConverter;
import mavliwala.nazmuddin.data.repositories.UserToEntityConverter;
import mavliwala.nazmuddin.domain.register.RegisterRepository;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ChildActivity;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVOToUserConverter;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterView;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */


@ChildActivity
@Module
public class RegisterModule {

    private final RegisterActivity activity;

    public RegisterModule(RegisterActivity activity) {
        this.activity = activity;
    }

    @ChildActivity
    @Provides
    public RegisterView provideRegisterView() {
        return this.activity;
    }

    @ChildActivity
    @Provides
    public RegisterRepository provdideRepository(RegisterDataRepository repository) {
        return repository;
    }

    @ChildActivity
    @Provides
    public UserVOToUserConverter providePresentationToDomainConverter() {
        return new UserVOToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserEntityToUserConverter provideDataToDomainConverter() {
        return new UserEntityToUserConverter();
    }

    @ChildActivity
    @Provides
    public UserToEntityConverter provideDomainToDataConverter() {
        return new UserToEntityConverter();
    }

}
