package mavliwala.nazmuddin.zoloassignment.base.views.helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;

import javax.inject.Inject;

import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ActivityContext;
import mavliwala.nazmuddin.zoloassignment.app.di.identifiers.ScopedActivity;

/**
 * Created by nazmuddinmavliwala on 01/03/17.
 */

@ScopedActivity
public class NavigationManager implements Navigator {

    private final Context context;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationManager(@ActivityContext Context context) {
        this.context = context;
        this.fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
    }

    @Override
    public void addFragment(@IdRes int containerId, @NonNull Fragment fragment) {
        String tag = getTag(fragment);
        this.fragmentManager
                .beginTransaction()
                .add(containerId,fragment,tag)
                .commit();
    }

    @Override
    public void removeFragment(Class<? extends Fragment> clazz) {
        if (isFragmentPresent(clazz)) {
            Fragment fragment = getFragment(clazz);
            this.fragmentManager.beginTransaction().remove(fragment).commit();
        }
    }

    @Override
    public void showFragment(@IdRes int containerId, Fragment fragment) {
        @SuppressWarnings("RestrictedApi") List<Fragment> fragments = this.fragmentManager.getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment1 : fragments) {
                this.fragmentManager.beginTransaction().remove(fragment1).commit();
            }
        }
        addFragment(containerId,fragment);
    }

    @Override
    public boolean isFragmentPresent(Class<? extends Fragment> clazz) {
        return getFragment(clazz) != null;
    }

    @Override
    public <T extends Fragment> T getFragment(Class<T> clazz) {
        //noinspection unchecked
        return (T) this.fragmentManager.findFragmentByTag(clazz.getName());
    }

    @Override
    public void replaceFragment(@IdRes int containerId, Fragment fragment) {
        String tag = getTag(fragment);
        this.fragmentManager
                .beginTransaction()
                .replace(containerId,fragment,tag)
                .commit();
    }

    @Override
    public void showDialogFragment(@NonNull DialogFragment fragment) {
        fragment.show(this.fragmentManager,fragment.getClass().getName());
    }

    @Override
    public void navigate(@NonNull Class<? extends AppCompatActivity> clazz) {
        Intent intent = new Intent(this.context,clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.context.startActivity(intent);
        ((AppCompatActivity)this.context).overridePendingTransition(0,0);
    }

    @Override
    public void navigate(@NonNull Class<? extends AppCompatActivity> clazz,
                         @NonNull Bundle bundle) {
        Intent intent = new Intent(this.context,clazz);
        this.context.startActivity(intent,bundle);
    }

    @Override
    public void navigate(@NonNull Intent intent
            ,@NonNull Bundle bundle) {
        this.context.startActivity(intent,bundle);
    }

    @Override
    public void navigateForResult(
            @NotNull Class<? extends AppCompatActivity> clazz,
            int requestCode) {
        Intent intent = new Intent(this.context,clazz);
        ((AppCompatActivity)this.context).startActivityForResult(intent,requestCode);
    }

    @Override
    public void navigateForResult(
            @NotNull Class<? extends AppCompatActivity> clazz,
            int requestCode,
            @NonNull Bundle bundle) {
        Intent intent = new Intent(this.context,clazz);
        ((AppCompatActivity)this.context).startActivityForResult(intent,requestCode,bundle);
    }

    @Override
    public void navigateWithTransition(@NonNull Class<? extends AppCompatActivity> clazz,
                                       @NonNull View transitView,
                                       @NonNull String viewTransitionName) {

    }

    @Override
    public void navigateWithTransition(@NonNull Intent intent,
                                       @NonNull View transitView,
                                       @NonNull String viewTransitionName) {

    }

    @Override
    public void navigateWithTransition(@NonNull Intent intent,
                                       @NonNull Bundle bundle,
                                       @NonNull View transitView,
                                       @NonNull String viewTransitionName) {

    }

    @Override
    public void navigateWithTransition(@NonNull Class<? extends AppCompatActivity> clazz,
                                       @NonNull Bundle bundle,
                                       @NonNull View transitView,
                                       @NonNull String viewTransitionName) {

    }

    @Override
    public void navigateWithTransitionForResult(@NonNull Class<? extends AppCompatActivity> clazz,
                                                @NonNull View transitView,
                                                @NonNull String viewTransitionName,
                                                int requestCode) {
        Intent intent = new Intent(context, clazz);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation((AppCompatActivity) context, transitView, viewTransitionName);
        this.context.startActivity(intent, options.toBundle());

    }

    @Override
    public void navigateWithTransitionForResult(@NonNull Class<? extends AppCompatActivity> clazz,
                                                @NonNull Bundle bundle,
                                                @NonNull View transitView,
                                                @NonNull String viewTransitionName,
                                                int requestCode) {

    }

    @Override
    public void navigateWithTransitionForResult(@NonNull Intent intent,
                                                @NonNull View transitView,
                                                @NonNull String viewTransitionName,
                                                int requestCode) {

    }

    @Override
    public void navigateWithTransitionForResult(@NonNull Intent intent,
                                                @NonNull Bundle bundle,
                                                @NonNull View transitView,
                                                @NonNull String viewTransitionName,
                                                int requestCode) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Fragment> T findFragmentByClass(@NonNull Class<T> clazz) {
        String tag = getTag(clazz);
        return (T) this.fragmentManager.findFragmentByTag(tag);
    }

    private String getTag(Fragment fragment) {
        return getTag(fragment.getClass());
    }

    private String getTag(Class<?> clazz) {
        return clazz.getName();
    }

}
