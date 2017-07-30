package mavliwala.nazmuddin.zoloassignment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import mavliwala.nazmuddin.domain.login.LoginUseCase;
import mavliwala.nazmuddin.zoloassignment.login.presenters.LoginPresenter;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginView;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresen {

    @Mock
    LoginView view;

    @Mock
    LoginUseCase useCase;

    @InjectMocks
    private LoginPresenter preseter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testValidate_ShouldFailWhenMobileAndPasswordIsNull() throws Exception {
        this.preseter.validateLogin(null,null);
    }
}
