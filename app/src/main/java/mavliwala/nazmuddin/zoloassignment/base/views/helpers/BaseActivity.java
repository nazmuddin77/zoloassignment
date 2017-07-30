package mavliwala.nazmuddin.zoloassignment.base.views.helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hendraanggrian.rx.activity.RxActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import mavliwala.nazmuddin.zoloassignment.app.ZoloApp;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ActivityContext;
import mavliwala.nazmuddin.zoloassignment.base.di.HasComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.components.BaseActivityComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.components.DaggerBaseActivityComponent;
import mavliwala.nazmuddin.zoloassignment.base.di.modules.BaseActivityModule;
import mavliwala.nazmuddin.zoloassignment.base.presenters.BaseView;
import mavliwala.nazmuddin.zoloassignment.base.views.LoaderDialog;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements
        HasComponent<BaseActivityComponent>, BaseView {

    private BaseActivityComponent component;

    @Inject public Navigator navigator;

    @Inject @ActivityContext Context context;

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
        return this.component;
    }

    protected abstract @LayoutRes int getLayout();

    public <T extends View> T finView(@IdRes int id) {
        return ButterKnife.findById(this,id);
    }

    @Override
    public void showLoading() {
        LoaderDialog loaderDialog = LoaderDialog.getInstance();
        loaderDialog.show(getSupportFragmentManager(),LoaderDialog.class.getName());
    }

    @Override
    public void hideLoading() {
        LoaderDialog dialog = (LoaderDialog) getSupportFragmentManager()
                .findFragmentByTag(LoaderDialog.class.getName());
        if (dialog != null) dialog.dismiss();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this.context,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RxActivity.onActivityResult(requestCode, resultCode, data);
    }
}
