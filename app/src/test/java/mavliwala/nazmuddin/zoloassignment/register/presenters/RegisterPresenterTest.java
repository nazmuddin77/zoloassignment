package mavliwala.nazmuddin.zoloassignment.register.presenters;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import mavliwala.nazmuddin.domain.register.RegisterUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;
import mavliwala.nazmuddin.zoloassignment.register.views.RegisterView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class RegisterPresenterTest {

    public static final String MOBILE_NUMBER_CANNOT_BE_EMPTY = "Mobile number cannot be empty";
    public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number";
    public static final String PASSWORD_CANNOT_BE_EMPTY = "Password cannot be empty";
    public static final String INVALID_PASSWORD = "Password should be atleast 6 digit long.";
    public static final String EMAIL_CANNOT_BE_EMPTY = "Email cannot be empty";
    public static final String INVALID_EMAIL = "Invalid email";

    @Mock
    RegisterView view;

    @Mock
    RegisterUseCase useCase;

    @Mock
    Context context;
    private RegisterPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(this.context.getString(R.string.empty_mobile_error)).thenReturn(MOBILE_NUMBER_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_mobile_error)).thenReturn(INVALID_MOBILE_NUMBER);
        when(this.context.getString(R.string.empty_password_error)).thenReturn(PASSWORD_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_password_error)).thenReturn(INVALID_PASSWORD);
        when(this.context.getString(R.string.empty_email_error)).thenReturn(EMAIL_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_email_error)).thenReturn(INVALID_EMAIL);
        when(this.view.getContext()).thenReturn(this.context);
        this.presenter = new RegisterPresenter(this.view,this.useCase,null);
    }


    @Test
    public void shouldReturnEmptyMobileError_WhenMobileIsEmpty() throws Exception {
        UserVO userVO = new UserVO();
        this.presenter.validate(userVO);
        verify(this.view).showError(MOBILE_NUMBER_CANNOT_BE_EMPTY);
    }

    @Test
    public void showReturnInvalidMobile_WhenMobileIsInvalid() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setMobile("we2rf23");
        this.presenter.validate(userVO);
        verify(this.view).showError(INVALID_MOBILE_NUMBER);
    }

    @Test
    public void showReturnEmptyEmailError_WhenEmailISEmpty() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setMobile("9892887832");
        userVO.setPassword("123456");
        this.presenter.validate(userVO);
        verify(this.view).showError(EMAIL_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldReturnInvalidEmailError_WhenEmailIsInvalid() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setMobile("9892887832");
        userVO.setPassword("123456");
        userVO.setEmail("23e3tt");
        this.presenter.validate(userVO);
        verify(this.view).showError(INVALID_EMAIL);
    }

    @Test
    public void showReturnEmptyPassword_WhenPasswordIsEmpty() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setMobile("9892887832");
        userVO.setName("nazazm");
        userVO.setEmail("nazam@gmail.com");
        this.presenter.validate(userVO);
        verify(this.view).showError(PASSWORD_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldReturnInvalidPassword_WhenPasswordIsInvalid() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setMobile("9892887832");
        userVO.setPassword("1233");
        userVO.setName("nazazm");
        userVO.setEmail("nazam@gmail.com");
        this.presenter.validate(userVO);
        verify(this.view).showError(INVALID_PASSWORD);
    }

}