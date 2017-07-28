package mavliwala.nazmuddin.zoloassignment.base.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ActivityContext;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ScopedActivity;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.NavigationManager;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.Navigator;

/**
 * Created by nazmuddinmavliwala on 02/03/17.
 */


@ScopedActivity
@Module
public class BaseActivityModule {

    private final BaseActivity activity;

    public BaseActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @ScopedActivity
    @Provides
    @ActivityContext
    public Context provideContext() {
        return this.activity;
    }

    @ScopedActivity
    @Provides
    public BaseActivity provideActivity() {
        return this.activity;
    }

    @ScopedActivity
    @Provides
    public Navigator provideNavigator(@ActivityContext Context context) {
        return new NavigationManager(context);
    }
}
