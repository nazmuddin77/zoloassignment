package mavliwala.nazmuddin.zoloassignment.forgotpassword.presenters;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import mavliwala.nazmuddin.domain.forgotpassword.ForgotPasswordUseCase;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.forgotpassword.views.ForgotPasswordView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class ForgotPasswordPresenterTest {

    public static final String EMAIL_CANNOT_BE_EMPTY = "Email cannot be empty";
    public static final String INVALID_EMAIL = "Invalid email";

    @Mock
    ForgotPasswordView view;

    @Mock
    ForgotPasswordUseCase useCase;

    @Mock
    Context context;
    private ForgotPasswordPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(this.context.getString(R.string.empty_email_error)).thenReturn(EMAIL_CANNOT_BE_EMPTY);
        when(this.context.getString(R.string.invalid_email_error)).thenReturn(INVALID_EMAIL);
        when(this.view.getContext()).thenReturn(this.context);
        this.presenter = new ForgotPasswordPresenter(this.view,this.useCase,null);
    }

    @Test
    public void showReturnEmptyEmailError_WhenEmailISEmpty() throws Exception {
        this.presenter.validate(null);
        verify(this.view).showError(EMAIL_CANNOT_BE_EMPTY);
    }

    @Test
    public void shouldReturnInvalidEmailError_WhenEmailIsInvalid() throws Exception {
        this.presenter.validate("defgv3gb");
        verify(this.view).showError(INVALID_EMAIL);
    }

    @Test
    public void validate_HappyCase() throws Exception {
        this.presenter.validate("nazam@gmail.com");
        verify(this.view).onSuccessFullValidation();
    }
}