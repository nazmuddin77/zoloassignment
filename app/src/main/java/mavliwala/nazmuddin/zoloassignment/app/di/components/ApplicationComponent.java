package mavliwala.nazmuddin.zoloassignment.app.di.components;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import java.io.File;

import javax.inject.Singleton;

import dagger.Component;
import mavliwala.nazmuddin.data.disc.ApplicationContext;
import mavliwala.nazmuddin.data.disc.SharedPrefService;
import mavliwala.nazmuddin.data.network.NetworkService;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.ApplicationModule;
import mavliwala.nazmuddin.zoloassignment.app.di.modules.DataModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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

    Gson getGson();

    OkHttpClient getOkHttpClient();

    Retrofit getRetrofit();

    NetworkService getNetworkService();

    SharedPrefService getSharedPrefService();

    File getCacheDir();
}
