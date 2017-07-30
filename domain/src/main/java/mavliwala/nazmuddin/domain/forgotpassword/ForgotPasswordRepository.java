package mavliwala.nazmuddin.domain.forgotpassword;

import mavliwala.nazmuddin.domain.Repository;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface ForgotPasswordRepository extends Repository {

    Observable<Response<User>> update(User user);
}
