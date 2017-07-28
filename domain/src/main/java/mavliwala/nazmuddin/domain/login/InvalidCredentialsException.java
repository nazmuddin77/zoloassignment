package mavliwala.nazmuddin.domain.login;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class InvalidCredentialsException extends Throwable {

    public Throwable createInstance() {
        return new InvalidCredentialsException();
    }
}
