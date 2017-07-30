package mavliwala.nazmuddin.domain.forgotpassword;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class UnhandledException extends Throwable {

    private static final String message = "something went wrong.";

    public UnhandledException() {
        super(message);
    }

    public UnhandledException(String message) {
        super(message);
    }

    public UnhandledException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnhandledException(Throwable cause) {
        super(cause);
    }

    public static Throwable createInstance() {
        return new UnhandledException();
    }
}
