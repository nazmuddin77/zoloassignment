package mavliwala.nazmuddin.domain.register;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserWithEmailAleradyExistsException extends Throwable {

    public static Throwable createInstance() {
        return new UserWithEmailAleradyExistsException();
    }
}
