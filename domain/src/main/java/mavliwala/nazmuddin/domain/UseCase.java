package mavliwala.nazmuddin.domain;

import java.util.concurrent.TimeUnit;

import mavliwala.nazmuddin.domain.executers.ExecutionThread;
import mavliwala.nazmuddin.domain.executers.PostExecutionThread;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by nazmuddinmavliwala on 12/03/17.
 */

public abstract class UseCase<T extends Repository> {

    protected final ExecutionThread executionThread;
    protected final PostExecutionThread postExecutionThread;
    protected final T repository;
    protected Subscription subscriber;

    public UseCase(ExecutionThread executionThread,
                   PostExecutionThread postExecutionThread,
                   T repository) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
        this.repository = repository;
    }

    protected <P>void execute(Observable<P> observable, Subscriber<P> subscriber) {
        this.subscriber = getScheduledObservable(observable)
                .subscribe(subscriber);

    }

    protected <P>void execute(Observable<P> observable, Action1<P> action1) {
        this.subscriber = getScheduledObservable(observable)
                .subscribe(action1);

    }

    protected  <P> Observable<P> getScheduledObservable(Observable<P> observable) {
        return observable.subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

    protected <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .delay(1000, TimeUnit.MILLISECONDS)
                        .subscribeOn(executionThread.getScheduler())
                        .observeOn(postExecutionThread.getScheduler());
            }
        };
    }


    public void unsubscribe() {
        if (this.subscriber != null) this.subscriber.unsubscribe();
    }


}
