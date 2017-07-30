package mavliwala.nazmuddin.zoloassignment.base.views.helpers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by nazmuddinmavliwala on 12/03/17.
 */

public interface Navigator {

    void addFragment(@IdRes int containerId, @NonNull Fragment fragment);

    void removeFragment(Class<? extends Fragment> clazz);

    void showFragment(@IdRes int containerId, Fragment fragment);

    boolean isFragmentPresent(Class<? extends Fragment> clazz);

    <T extends Fragment> T getFragment(Class<T> clazz);

    void replaceFragment(@IdRes int containerId, Fragment fragment);

    void showDialogFragment(@NonNull DialogFragment fragment);

    <T extends Fragment> T findFragmentByClass(@NonNull Class<T> clazz);

    void navigate(@NonNull Class<? extends AppCompatActivity> clazz);

    void navigate(@NonNull Class<? extends AppCompatActivity> clazz, @NonNull Bundle bundle);

    void navigate(@NonNull Intent intent, @NonNull Bundle bundle);

    void navigateForResult(@NonNull Class<? extends AppCompatActivity> clazz, int requestCode);

    void navigateForResult(@NonNull Class<? extends AppCompatActivity> clazz, int requestCode,
                           @NonNull Bundle bundle);

    void navigateWithTransition(@NonNull Class<? extends AppCompatActivity> clazz,
                                @NonNull View transitView,
                                @NonNull String viewTransitionName);

    void navigateWithTransition(@NonNull Intent intent,
                                @NonNull View transitView,
                                @NonNull String viewTransitionName);

    void navigateWithTransition(@NonNull Intent intent,
                                @NonNull Bundle bundle,
                                @NonNull View transitView,
                                @NonNull String viewTransitionName);

    void navigateWithTransition(@NonNull Class<? extends AppCompatActivity> clazz,
                                @NonNull Bundle bundle,
                                @NonNull View transitView,
                                @NonNull String viewTransitionName);

    void navigateWithTransitionForResult(@NonNull Class<? extends AppCompatActivity> clazz,
                                         @NonNull View transitView,
                                         @NonNull String viewTransitionName,
                                         int requestCode);

    void navigateWithTransitionForResult(@NonNull Class<? extends AppCompatActivity> clazz,
                                         @NonNull Bundle bundle,
                                         @NonNull View transitView,
                                         @NonNull String viewTransitionName,
                                         int requestCode);

    void navigateWithTransitionForResult(@NonNull Intent intent,
                                         @NonNull View transitView,
                                         @NonNull String viewTransitionName,
                                         int requestCode);

    void navigateWithTransitionForResult(@NonNull Intent intent,
                                         @NonNull Bundle bundle,
                                         @NonNull View transitView,
                                         @NonNull String viewTransitionName,
                                         int requestCode);





}
