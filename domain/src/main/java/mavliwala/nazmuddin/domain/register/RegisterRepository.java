package mavliwala.nazmuddin.domain.register;

import java.util.List;

import mavliwala.nazmuddin.domain.Repository;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public interface RegisterRepository extends Repository {

    Observable<List<User>> getUserWithMobile(String mobile);

    Observable<List<User>> getUserWithEmail(String email);

    Observable<Response> register(User user);
}
