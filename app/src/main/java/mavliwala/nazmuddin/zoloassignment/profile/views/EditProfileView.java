package mavliwala.nazmuddin.zoloassignment.profile.views;

import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface EditProfileView extends BaseView {
    void returnUpdatedProfile(UserVO userVO);
}
