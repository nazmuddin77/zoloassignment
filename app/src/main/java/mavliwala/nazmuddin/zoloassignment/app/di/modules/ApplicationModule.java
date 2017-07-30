package mavliwala.nazmuddin.zoloassignment.app.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.disc.ApplicationContext;

/**
 * Created by nazmuddinmavliwala on 22/01/17.
 */


@Module
@Singleton
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    public Context provideApplicationContext() {
        return this.application;
    }

}
