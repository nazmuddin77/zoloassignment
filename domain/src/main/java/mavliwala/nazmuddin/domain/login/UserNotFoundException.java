package mavliwala.nazmuddin.domain.login;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class UserNotFoundException extends Throwable {
    public static final String message = "User not found, please register to continue.";

    public UserNotFoundException() {
        super(message);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public static Throwable createInstance() {
        return new UserNotFoundException();
    }
}
