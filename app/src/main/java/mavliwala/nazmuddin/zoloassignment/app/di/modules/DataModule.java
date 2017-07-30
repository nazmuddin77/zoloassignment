package mavliwala.nazmuddin.zoloassignment.app.di.modules;

import android.content.ContentResolver;
import android.content.Context;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.database.DatabaseManager;
import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.disc.ApplicationContext;
import mavliwala.nazmuddin.data.disc.SharedPrefManager;
import mavliwala.nazmuddin.data.disc.SharedPrefService;

/**
 * Created by nazmuddinmavliwala on 22/01/17.
 */


@Module
@Singleton
public class DataModule {

    @Singleton
    @Provides
    public ContentResolver provideResolver(@ApplicationContext Context context) {
        return context.getContentResolver();
    }

    @Provides
    @Singleton
    public SharedPrefService provideSharedPrefService(@ApplicationContext Context context) {
        return new SharedPrefManager(context);
    }

    @Provides
    @Singleton
    public DaoSession provideDaosession(DatabaseManager manager) {
        return manager.getDaoSession();
    }

    @Provides
    @Singleton
    public File provideCacheDir(@ApplicationContext Context context) {
        return context.getCacheDir();
    }
}
