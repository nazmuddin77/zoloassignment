package mavliwala.nazmuddin.zoloassignment.register.models;

import mavliwala.nazmuddin.domain.Converter;
import mavliwala.nazmuddin.domain.login.models.User;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserVOToUserConverter implements Converter<UserVO,User> {
    @Override
    public User convert(UserVO data) {
        if (data == null) return null;
        return new User.UserBuilder()
                .setName(data.getName())
                .setEmail(data.getEmail())
                .setReferralCode(data.getReferralCode())
                .setMobile(data.getMobile())
                .setId(data.getId())
                .setPassword(data.getPassword())
                .createUser();
    }
}
