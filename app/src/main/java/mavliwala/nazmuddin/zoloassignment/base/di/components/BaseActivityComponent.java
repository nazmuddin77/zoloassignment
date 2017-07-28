package mavliwala.nazmuddin.zoloassignment.base.di.components;

import android.content.Context;

import dagger.Component;
import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.disc.ApplicationContext;
import mavliwala.nazmuddin.data.disc.SharedPrefService;
import mavliwala.nazmuddin.data.network.NetworkService;
import mavliwala.nazmuddin.zoloassignment.app.di.components.ApplicationComponent;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ActivityContext;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ScopedActivity;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.RxModule;
import mavliwala.nazmuddin.zoloassignment.base.di.modules.BaseActivityModule;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.Navigator;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.di.ForgotPasswordComponent;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.di.ForgotPasswordModule;
import mavliwala.nazmuddin.zoloassignment.login.di.LoginComponent;
import mavliwala.nazmuddin.zoloassignment.login.di.LoginModule;
import mavliwala.nazmuddin.zoloassignment.profile.di.EditProfileComponent;
import mavliwala.nazmuddin.zoloassignment.profile.di.EditProfileModule;
import mavliwala.nazmuddin.zoloassignment.profile.di.ProfileComponent;
import mavliwala.nazmuddin.zoloassignment.profile.di.ProfileModule;
import mavliwala.nazmuddin.zoloassignment.register.di.RegisterComponent;
import mavliwala.nazmuddin.zoloassignment.register.di.RegisterModule;

/**
 * Created by nazmuddinmavliwala on 02/03/17.
 */


@ScopedActivity
@Component(
        modules = {
                BaseActivityModule.class,
                RxModule.class
        },
        dependencies = {
                ApplicationComponent.class
        }
)
public interface  BaseActivityComponent {

    @ApplicationContext
    Context getContext();

    @ActivityContext
    Context getActivityContext();

    BaseActivity getActivity();

    SharedPrefService sharedPrefService();

    Navigator getNavigator();

    NetworkService provideService();

    DaoSession provideDaoSession();

    void inject(BaseActivity baseActivity);

    LoginComponent provideLoginComponent(LoginModule module);

    RegisterComponent provideRegisterComponent(RegisterModule module);

    ForgotPasswordComponent provideForgotPasswordComponent(ForgotPasswordModule forgotPasswordModule);

    ProfileComponent provideProfileComponent(ProfileModule profileModule);

    EditProfileComponent provideEditProfileComponent(EditProfileModule editProfileModule);
}
