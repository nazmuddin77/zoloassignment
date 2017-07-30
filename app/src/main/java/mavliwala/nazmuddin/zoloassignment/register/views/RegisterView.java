package mavliwala.nazmuddin.zoloassignment.register.views;

import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface RegisterView extends BaseView {
    void navigateToLogin(UserVO userVO);

    void onSuccessFullValidation(UserVO userVO);
}
