package mavliwala.nazmuddin.domain.login;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class InvalidCredentialsException extends Throwable {

    public static final String message = "Invalid Password";

    public InvalidCredentialsException() {
        super(message);
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }

    public InvalidCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Throwable createInstance() {
        return new InvalidCredentialsException();
    }
}
