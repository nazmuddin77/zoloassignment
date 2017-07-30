package mavliwala.nazmuddin.data.repositories;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.domain.forgotpassword.ForgotPasswordRepository;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class ForgotPasswordDataRepository implements ForgotPasswordRepository {
    private final DaoSession daoSession;
    private final UserToEntityConverter entityConverter;
    private final UserEntityToUserConverter converter;

    @Inject
    public ForgotPasswordDataRepository(DaoSession daoSession,
                                        UserToEntityConverter entityConverter,
                                        UserEntityToUserConverter converter) {
        this.daoSession = daoSession;
        this.entityConverter = entityConverter;
        this.converter = converter;
    }

    @Override
    public Observable<Response<User>> update(User user) {
        UserEntity userEntity = this.entityConverter.convert(user);
        return this.daoSession.getUserEntityDao().rx()
                .insertOrReplace(userEntity)
                .switchMap(new Func1<UserEntity, Observable<? extends Response<User>>>() {
                    @Override
                    public Observable<? extends Response<User>> call(UserEntity userEntity) {
                        User user1 = converter.convert(userEntity);
                        Response<User> response =  new Response.Success<>(user1);
                        return Observable.just(response);
                    }
                });
    }
}
