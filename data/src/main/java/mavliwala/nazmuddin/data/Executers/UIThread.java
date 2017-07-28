package mavliwala.nazmuddin.data.Executers;

import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by nazmuddinmavliwala on 20/01/17.
 */

public class UIThread implements PostExecutionThread {

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
