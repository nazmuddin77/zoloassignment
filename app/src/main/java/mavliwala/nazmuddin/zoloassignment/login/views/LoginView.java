package mavliwala.nazmuddin.zoloassignment.login.views;

import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public interface LoginView extends BaseView {
    void navigateToProfileActivity(UserVO user);

    void navigateToForgotPasswordActivity(UserVO userVO);
}
