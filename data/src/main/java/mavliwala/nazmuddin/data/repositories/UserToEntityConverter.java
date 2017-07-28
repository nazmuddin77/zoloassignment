package mavliwala.nazmuddin.data.repositories;

import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.domain.Converter;
import mavliwala.nazmuddin.domain.login.models.User;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserToEntityConverter implements Converter<User,UserEntity> {

    @Override
    public UserEntity convert(User data) {
        if (data == null) return null;
        UserEntity entity = new UserEntity();
        entity.setName(data.getName());
        entity.setMobile(data.getMobile());
        entity.setEmail(data.getEmail());
        entity.setReferralCode(data.getReferralCode());
        return entity;
    }
}
