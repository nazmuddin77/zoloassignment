package mavliwala.nazmuddin.zoloassignment.profile.views;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.profile.di.EditProfileModule;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.EditProfilePresenter;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class EditProfileActivity extends BaseActivity {

    @Inject
    EditProfilePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideEditProfileComponent(new EditProfileModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_edit_profile;
    }
}
