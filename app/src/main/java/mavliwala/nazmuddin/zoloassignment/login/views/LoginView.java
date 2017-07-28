package mavliwala.nazmuddin.zoloassignment.login.views;

import android.support.annotation.StringRes;

import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public interface LoginView extends BaseView {
    void showError(@StringRes int resId);
}
