package mavliwala.nazmuddin.data.repositories;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.profile.ProfileRepository;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class ProfileDataRepository implements ProfileRepository {

    private final DaoSession daoSession;
    private final UserEntityToUserConverter converter;

    @Inject
    public ProfileDataRepository(DaoSession daoSession, UserEntityToUserConverter converter) {
        this.daoSession = daoSession;
        this.converter = converter;
    }

    @Override
    public Observable<User> getUser(Long userId) {
        return this.daoSession.getUserEntityDao()
                .rx()
                .load(userId)
                .map(new Func1<UserEntity, User>() {
                    @Override
                    public User call(UserEntity userEntity) {
                        return converter.convert(userEntity);
                    }
                });
    }
}
