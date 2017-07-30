package mavliwala.nazmuddin.domain.register;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserWithMobileAlreadyExistException extends Throwable {
    private static final String message = "User with given mobile already exists.";

    public UserWithMobileAlreadyExistException() {
        super(message);
    }

    public UserWithMobileAlreadyExistException(String message) {
        super(message);
    }

    public UserWithMobileAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWithMobileAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public static Throwable createInstance() {
        return new UserWithMobileAlreadyExistException();
    }
}
