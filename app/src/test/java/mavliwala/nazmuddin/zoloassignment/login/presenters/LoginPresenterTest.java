package mavliwala.nazmuddin.zoloassignment.login.presenters;

import android.content.Context;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import mavliwala.nazmuddin.domain.login.LoginUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    public static final String MOBILE_NUMBER_CANNOT_BE_EMPTY = "Mobile number cannot be empty";
    public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number";
    public static final String PASSWORD_CANNOT_BE_EMPTY = "Password cannot be empty";
    public static final String INVALID_PASSWORD = "Password should be atleast 6 digit long.";
    @Mock
    LoginView view;

    @Mock
    LoginUseCase useCase;

    @Mock
    Context context;

    LoginPresenter presenter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(this.context.getString(R.string.empty_mobile_error)).thenReturn(MOBILE_NUMBER_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_mobile_error)).thenReturn(INVALID_MOBILE_NUMBER);
        when(this.context.getString(R.string.empty_password_error)).thenReturn(PASSWORD_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_password_error)).thenReturn(INVALID_PASSWORD);
        when(this.view.getContext()).thenReturn(this.context);
        this.presenter = new LoginPresenter(this.view,this.useCase,null);
    }

    @Test
    public void shouldReturnEmptyMobileError_WhenMobileIsEmpty() throws Exception {
        this.presenter.validateLogin(null,null);
        verify(this.view).showError(MOBILE_NUMBER_CANNOT_BE_EMPTY);
    }

    @Test
    public void showReturnInvalidMobile_WhenMobileIsInvalid() throws Exception {
        this.presenter.validateLogin("12345",null);
        verify(this.view).showError(INVALID_MOBILE_NUMBER);
    }

    @Test
    public void showReturnEmptyPassword_WhenPasswordIsEmpty() throws Exception {
        this.presenter.validateLogin("9892887832",null);
        verify(this.view).showError(PASSWORD_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldReturnInvalidPassword_WhenPasswordIsInvalid() throws Exception {
        this.presenter.validateLogin("9892887832","1234");
        verify(this.view).showError(INVALID_PASSWORD);
    }

    @Test
    public void validateLogin_HappyCase() throws Exception {
        this.presenter.validateLogin("9892887832","12345678");
        verify(this.view).onSuccessFullValidation("9892887832","12345678");
    }
}