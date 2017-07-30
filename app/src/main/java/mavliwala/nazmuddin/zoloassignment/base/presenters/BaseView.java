package mavliwala.nazmuddin.zoloassignment.base.presenters;

import android.content.Context;

/**
 * Created by nazmuddinmavliwala on 02/06/17.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showError(String error);
    Context getContext();
}
