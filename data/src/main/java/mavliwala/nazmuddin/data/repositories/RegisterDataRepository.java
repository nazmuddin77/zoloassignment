package mavliwala.nazmuddin.data.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.data.database.entities.UserEntityDao;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.register.RegisterRepository;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class RegisterDataRepository implements RegisterRepository {

    private final DaoSession session;
    private final UserEntityToUserConverter entityToUserConverter;
    private final UserToEntityConverter userToEntityConverter;

    @Inject
    public RegisterDataRepository(DaoSession session,
                                  UserEntityToUserConverter entityToUserConverter,
                                  UserToEntityConverter userToEntityConverter){
        this.session = session;
        this.entityToUserConverter = entityToUserConverter;
        this.userToEntityConverter = userToEntityConverter;
    }

    @Override
    public Observable<List<User>> getUserWithMobile(String mobile) {
        return this.session
                .getUserEntityDao()
                .queryBuilder()
                .where(UserEntityDao.Properties.Mobile.eq(mobile))
                .rx()
                .list()
                .switchMap(new Func1<List<UserEntity>, Observable<List<User>>>() {
                    @Override
                    public Observable<List<User>> call(List<UserEntity> userEntities) {
                        List<User> users = new ArrayList<>();
                        if (userEntities != null && userEntities.size() > 0) {
                            for (UserEntity userEntity : userEntities) {
                                users.add(entityToUserConverter.convert(userEntity));
                            }
                        }
                        return Observable.just(users);
                    }
                });
    }

    @Override
    public Observable<List<User>> getUserWithEmail(String email) {
        return this.session
                .getUserEntityDao()
                .queryBuilder()
                .where(UserEntityDao.Properties.Email.eq(email))
                .rx()
                .list()
                .switchMap(new Func1<List<UserEntity>, Observable<List<User>>>() {
                    @Override
                    public Observable<List<User>> call(List<UserEntity> userEntities) {
                        List<User> users = new ArrayList<>();
                        if (userEntities != null && userEntities.size() > 0) {
                            for (UserEntity userEntity : userEntities) {
                                users.add(entityToUserConverter.convert(userEntity));
                            }
                        }
                        return Observable.just(users);
                    }
                });
    }

    @Override
    public Observable<Response<User>> register(User user) {
        UserEntity entity = this.userToEntityConverter.convert(user);
        return this.session.getUserEntityDao().rx()
                .insertOrReplace(entity)
                .switchMap(new Func1<UserEntity, Observable<Response<User>>>() {
                    @Override
                    public Observable<Response<User>> call(UserEntity userEntity) {
                        Response<User> response = new Response.Success<>(entityToUserConverter.convert(userEntity));
                        return Observable.just(response);
                    }
                });
    }
}
