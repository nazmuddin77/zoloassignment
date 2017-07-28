package mavliwala.nazmuddin.zoloassignment.base.di.components;

import android.content.Context;

import dagger.Component;
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

}
