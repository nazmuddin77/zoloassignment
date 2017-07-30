package mavliwala.nazmuddin.zoloassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import mavliwala.nazmuddin.data.disc.SharedPrefService;
import mavliwala.nazmuddin.zoloassignment.app.ZoloApp;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.login.views.LoginActivity;
import mavliwala.nazmuddin.zoloassignment.profile.views.ProfileActivity;

import static mavliwala.nazmuddin.data.disc.SharedPrefConstants.USER_ID;
import static mavliwala.nazmuddin.data.repositories.LoginDataRepository.LOGGED_IN;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPrefService service = ZoloApp.getComponent().getSharedPrefService();
        if (service.retrieveValue(LOGGED_IN,false)) this.navigator.navigate(LoginActivity.class);
        else {
            Long userId = (long) service.retrieveValue(USER_ID, -1);
            Intent intent = new Intent(SplashActivity.this, ProfileActivity.class);
            intent.putExtra(USER_ID,userId);
            startActivity(intent);
        }
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }
}
