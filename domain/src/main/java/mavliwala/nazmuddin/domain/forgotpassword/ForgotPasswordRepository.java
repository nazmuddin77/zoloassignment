package mavliwala.nazmuddin.domain.forgotpassword;

import java.util.List;

import mavliwala.nazmuddin.domain.Repository;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface ForgotPasswordRepository extends Repository {
    Observable<List<User>> getUserWithEmail();
}
