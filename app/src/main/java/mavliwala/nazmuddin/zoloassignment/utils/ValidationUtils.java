package mavliwala.nazmuddin.zoloassignment.utils;

import android.support.annotation.NonNull;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class ValidationUtils {


    private static final String MOBILE_NUMBER_PATTERN = "^[789]\\d{9}$";
    private static final String NAME_PATTERN = "^[a-zA-Z\\s]+";
    private static final String EMAIL_PATTERN = Patterns.EMAIL_ADDRESS.toString();

    public static boolean isValidMobile(@NonNull String mobile) {
        return isValidRegex(MOBILE_NUMBER_PATTERN,mobile);
    }

    public static boolean isValidRegex(@NonNull String pattern,
                                       @NonNull String value) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(value);
        return matcher.matches();
    }

    public static boolean isValidName(@NonNull String name) {
        return isValidRegex(NAME_PATTERN,name);
    }

    public static boolean isValidEmail(@NonNull String email) {
        return isValidRegex(EMAIL_PATTERN,email);
    }
}
