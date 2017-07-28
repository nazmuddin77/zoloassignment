package mavliwala.nazmuddin.zoloassignment.base.views.helpers;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import mavliwala.nazmuddin.zoloassignment.app.ZoloApp;
import mavliwala.nazmuddin.zoloassignment.base.di.HasComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.components.BaseActivityComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.components.DaggerBaseActivityComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.modules.BaseActivityModule;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<BaseActivityComponent> {

    private BaseActivityComponent component;

    @Inject
    public Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.component = DaggerBaseActivityComponent.builder()
                .applicationComponent(ZoloApp.getComponent())
                .baseActivityModule(new BaseActivityModule(this))
                .build();
        this.component.inject(this);
        ButterKnife.bind(this);
    }

    @Override
    public BaseActivityComponent getComponent() {
        return null;
    }

    protected abstract @LayoutRes int getLayout();
}
