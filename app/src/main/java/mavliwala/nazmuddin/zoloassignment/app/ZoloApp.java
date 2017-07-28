package mavliwala.nazmuddin.zoloassignment.app;

import android.app.Application;

import mavliwala.nazmuddin.zoloassignment.app.di.components.ApplicationComponent;

/**
 * Created by nazmuddinmavliwala on 20/01/17.
 */

public class ZoloApp extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

}
