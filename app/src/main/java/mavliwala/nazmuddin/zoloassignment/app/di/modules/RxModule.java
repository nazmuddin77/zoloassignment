package mavliwala.nazmuddin.zoloassignment.app.di.modules;

import dagger.Module;
import dagger.Provides;
import mavliwala.nazmuddin.data.Executers.BackgroundThread;
import mavliwala.nazmuddin.data.Executers.UIThread;
import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ScopedActivity;

/**
 * Created by nazmuddinmavliwala on 12/03/17.
 */

@ScopedActivity
@Module
public class RxModule {

    @Provides
    @ScopedActivity
    public ExecutionThread provideExecutionThread() {
        return new BackgroundThread();
    }

    @ScopedActivity
    @Provides
    public PostExecutionThread providePostExecutionThread() {
        return new UIThread();
    }
}
