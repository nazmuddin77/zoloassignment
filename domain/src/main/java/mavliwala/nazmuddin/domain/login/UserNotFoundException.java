package mavliwala.nazmuddin.domain.login;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class UserNotFoundException extends Throwable {

    public static Throwable createInstance() {
        return new UserNotFoundException();
    }
}
