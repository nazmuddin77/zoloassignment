package mavliwala.nazmuddin.data.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.data.database.entities.UserEntityDao;
import mavliwala.nazmuddin.domain.login.LoginRepository;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class LoginDataRepository implements LoginRepository {

    private final DaoSession daoSession;
    private final UserEntityConverter converter;

    @Inject
    public LoginDataRepository(DaoSession daoSession,UserEntityConverter converter) {
        this.daoSession = daoSession;
        this.converter = converter;
    }

    @Override
    public Observable<List<User>> recognizeUser(String mobile) {
        return this.daoSession
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
                                users.add(converter.convert(userEntity));
                            }
                        }
                        return Observable.just(users);
                    }
                });
    }

    @Override
    public Observable<Response> login(String mobile, String password) {
        Response response;
        List<UserEntity> users = this.daoSession
                .getUserEntityDao()
                .queryBuilder()
                .where(UserEntityDao.Properties.Mobile.eq(mobile))
                .list();
        UserEntity userEntity = users.get(0);
        String pass = userEntity.getPassword();
        response = pass.equals(password) ? new Response.Success(): new Response.Error();
        return Observable.just(response);
    }
}
