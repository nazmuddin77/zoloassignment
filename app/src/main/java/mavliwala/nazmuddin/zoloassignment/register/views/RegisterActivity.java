package mavliwala.nazmuddin.zoloassignment.register.views;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.register.di.RegisterModule;
import mavliwala.nazmuddin.zoloassignment.register.presenters.RegisterPresenter;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class RegisterActivity extends BaseActivity {

    @Inject
    RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideRegisterComponent(new RegisterModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }
}
