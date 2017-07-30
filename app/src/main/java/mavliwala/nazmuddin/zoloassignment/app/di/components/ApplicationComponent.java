package mavliwala.nazmuddin.zoloassignment.app.di.components;

import android.app.Application;
import android.content.Context;

import java.io.File;

import javax.inject.Singleton;

import dagger.Component;
import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.disc.ApplicationContext;
import mavliwala.nazmuddin.data.disc.SharedPrefService;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.ApplicationModule;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.DataModule;

/**
 * Created by nazmuddinmavliwala on 22/01/17.
 */

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class
        }
)
public interface ApplicationComponent {

    @ApplicationContext
    Context getApplicationContext();

    Application getApplication();

    SharedPrefService getSharedPrefService();

    File getCacheDir();

    DaoSession provideDaoSession();
}
