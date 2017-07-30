package mavliwala.nazmuddin.zoloassignment.profile.presenters;

import mavliwala.nazmuddin.domain.Converter;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class UserToUserVOConverter implements Converter<User,UserVO> {
    @Override
    public UserVO convert(User data) {
        if (data == null) return null;
        return new UserVO.UserVOBuilder()
                .setId(data.getId())
                .setEmail(data.getEmail())
                .setMobile(data.getMobile())
                .setName(data.getName())
                .setPassword(data.getPassword())
                .setReferralCode(data.getReferralCode())
                .createUserVO();

    }
}
