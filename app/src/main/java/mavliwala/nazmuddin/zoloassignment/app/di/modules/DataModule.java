package mavliwala.nazmuddin.zoloassignment.app.di.modules;

import android.content.ContentResolver;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.database.DatabaseManager;
import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.disc.ApplicationContext;
import mavliwala.nazmuddin.data.disc.SharedPrefManager;
import mavliwala.nazmuddin.data.disc.SharedPrefService;
import mavliwala.nazmuddin.data.network.NetworkManager;
import mavliwala.nazmuddin.data.network.NetworkService;
import mavliwala.nazmuddin.data.network.RetrofitManager;
import mavliwala.nazmuddin.data.network.RetrofitService;
import mavliwala.nazmuddin.data.network.RxErrorHandlingCallAdapterFactory;
import mavliwala.nazmuddin.zoloassignment.utils.DateUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nazmuddinmavliwala on 22/01/17.
 */


@Module
@Singleton
public class DataModule {

    private static final String API_BASE_URL = "http:api1.aasaanjobs.com/";
    //private static final String API_BASE_URL = "https:api.aasaanjobs.com/";

    @Singleton
    @Provides
    public ContentResolver provideResolver(@ApplicationContext Context context) {
        return context.getContentResolver();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().setDateFormat(DateUtils.FORMAT_ONE).create();
    }


    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return  new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public RetrofitService provideRetrofitService(RetrofitManager manager) {
        return manager;
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService(NetworkManager manager) {
        return manager;
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
