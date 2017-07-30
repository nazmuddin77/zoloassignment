package mavliwala.nazmuddin.zoloassignment.utils;

import mavliwala.nazmuddin.domain.login.InvalidCredentialsException;
import mavliwala.nazmuddin.domain.login.UserNotFoundException;
import mavliwala.nazmuddin.domain.register.UserWithEmailAlreadyExistsException;
import mavliwala.nazmuddin.domain.register.UserWithMobileAlreadyExistException;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class ErrorMessageFactory {

    public static String create(Throwable throwable) {
        String message = "Something went wrong.";
        if ((throwable instanceof UserNotFoundException)
                ||(throwable instanceof InvalidCredentialsException)
                ||(throwable instanceof UserWithMobileAlreadyExistException)
                ||(throwable instanceof UserWithEmailAlreadyExistsException))
            return throwable.getMessage();
        return message;
    }
}
