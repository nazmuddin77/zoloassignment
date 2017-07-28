package mavliwala.nazmuddin.zoloassignment.app;

import android.app.Application;

import mavliwala.nazmuddin.zoloassignment.app.di.components.ApplicationComponent;
import mavliwala.nazmuddin.zoloassignment.app.di.components.DaggerApplicationComponent;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.ApplicationModule;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.DataModule;

/**
 * Created by nazmuddinmavliwala on 20/01/17.
 */

public class ZoloApp extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

}
