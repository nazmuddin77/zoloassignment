package mavliwala.nazmuddin.zoloassignment.base.presenters;


import android.support.annotation.StringRes;

/**
 * Created by nazmuddinmavliwala on 23/01/17.
 */
public abstract class BasePresenter<V extends BaseView> implements Presenter {

    protected final V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    public String getString(@StringRes int resId) {
        return this.view.getContext().getString(resId);
    }

}
