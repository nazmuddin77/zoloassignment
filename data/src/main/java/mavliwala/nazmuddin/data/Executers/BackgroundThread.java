package mavliwala.nazmuddin.data.Executers;

import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by nazmuddinmavliwala on 20/01/17.
 */

public class BackgroundThread implements ExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.newThread();
    }
}
