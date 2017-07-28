package mavliwala.nazmuddin.zoloassignment.base.views.helpers;

import android.support.v7.app.AppCompatActivity;

import mavliwala.nazmuddin.zoloassignment.base.di.HasComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.components.BaseActivityComponent;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<BaseActivityComponent> {


    @Override
    public BaseActivityComponent getComponent() {
        return null;
    }
}
