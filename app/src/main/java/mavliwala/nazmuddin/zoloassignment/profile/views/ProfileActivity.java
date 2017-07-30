package mavliwala.nazmuddin.zoloassignment.profile.views;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.profile.di.ProfileModule;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.ProfilePresenter;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideProfileComponent(new ProfileModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_profile;
    }
}
