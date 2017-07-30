package mavliwala.nazmuddin.domain.register;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserWithEmailAlreadyExistsException extends Throwable {

    private static  final String message = "User with given email already exists.";

    public UserWithEmailAlreadyExistsException() {
        super(message);
    }

    public UserWithEmailAlreadyExistsException(String message) {
        super(message);
    }

    public UserWithEmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWithEmailAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public static Throwable createInstance() {
        return new UserWithEmailAlreadyExistsException();
    }
}
