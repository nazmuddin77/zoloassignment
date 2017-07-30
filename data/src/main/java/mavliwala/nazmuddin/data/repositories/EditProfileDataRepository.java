package mavliwala.nazmuddin.data.repositories;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.database.entities.UserEntity;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import mavliwala.nazmuddin.domain.profile.EditProfileRepository;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class EditProfileDataRepository implements EditProfileRepository {

    private final DaoSession daoSession;
    private final UserToEntityConverter converter;
    private final UserEntityToUserConverter entityToUserConverter;

    @Inject
    public EditProfileDataRepository(DaoSession daoSession,
                                     UserToEntityConverter converter,
                                     UserEntityToUserConverter entityToUserConverter) {
        this.daoSession = daoSession;
        this.converter = converter;
        this.entityToUserConverter = entityToUserConverter;
    }

    @Override
    public Observable<Response<User>> update(User user) {
        UserEntity userEntity = this.converter.convert(user);
        return this.daoSession.getUserEntityDao()
                .rx()
                .insertOrReplace(userEntity)
                .switchMap(new Func1<UserEntity, Observable<Response<User>>>() {
                    @Override
                    public Observable<Response<User>> call(UserEntity userEntity) {
                        Response<User> response;
                        response = new Response.Success<>(entityToUserConverter.convert(userEntity));
                        return Observable.just(response);
                    }
                });
    }
}
