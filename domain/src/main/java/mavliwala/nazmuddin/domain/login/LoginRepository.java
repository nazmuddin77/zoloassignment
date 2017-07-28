package mavliwala.nazmuddin.domain.login;

import java.util.List;

import mavliwala.nazmuddin.domain.Repository;
import mavliwala.nazmuddin.domain.login.models.Response;
import mavliwala.nazmuddin.domain.login.models.User;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public interface LoginRepository extends Repository {

    Observable<List<User>> recognizeUser(String mobile);

    Observable<Response> login(String mobile, String password);
}
