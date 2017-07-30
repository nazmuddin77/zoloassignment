package mavliwala.nazmuddin.zoloassignment.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */
public class ValidationUtilsTest {

    @Test
    public void validateEmail_SadCase() throws Exception {
        boolean valid = ValidationUtils.isValidEmail("efg");
        assertThat(valid,is(false));
    }

    @Test
    public void validateEmail_HappyCase() throws Exception {
        boolean valid = ValidationUtils.isValidEmail("nazam@gmail.com");
        assertThat(valid,is(true));
    }

    @Test
    public void validateName_SadCase() throws Exception {
        boolean valid = ValidationUtils.isValidName("nazam@gmail.com");
        assertThat(valid,is(false));
    }

    @Test
    public void validateName_HappyCase() throws Exception {
        boolean valid = ValidationUtils.isValidName("nazam");
        assertThat(valid,is(true));
    }

    @Test
    public void validateMobile_SadCase() throws Exception {
        boolean valid = ValidationUtils.isValidMobile("nazam@gmail.com");
        assertThat(valid,is(false));
    }

    @Test
    public void validateMobile_HappyCase() throws Exception {
        boolean valid = ValidationUtils.isValidMobile("9892887832");
        assertThat(valid,is(true));
    }
}