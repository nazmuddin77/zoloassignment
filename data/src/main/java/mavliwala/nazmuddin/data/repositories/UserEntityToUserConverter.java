package mavliwala.nazmuddin.data.repositories;

import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.domain.Converter;
import mavliwala.nazmuddin.domain.login.models.User;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class UserEntityToUserConverter implements Converter<UserEntity,User> {

    @Override
    public User convert(UserEntity data) {
        if (data == null) return null;
        return new User.UserBuilder()
                .setId(data.getId())
                .setEmail(data.getEmail())
                .setMobile(data.getMobile())
                .setName(data.getName())
                .setReferralCode(data.getReferralCode())
                .createUser();
    }
}
