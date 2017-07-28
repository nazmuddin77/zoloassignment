package mavliwala.nazmuddin.zoloassignment.register.views;

import android.support.annotation.StringRes;

import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface RegisterView extends BaseView {
    void showError(@StringRes int resId);
}
