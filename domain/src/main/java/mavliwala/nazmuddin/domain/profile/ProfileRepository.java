package mavliwala.nazmuddin.domain.profile;

import mavliwala.nazmuddin.domain.Repository;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface ProfileRepository extends Repository {
    Observable<User> getUser(Long userId);

    void clearPref();

}
