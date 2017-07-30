package mavliwala.nazmuddin.zoloassignment.base.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mavliwala.nazmuddin.zoloassignment.R;

/**
 * Created by nazmuddinmavliwala on 30/07/17.
 */

public class LoaderDialog extends AppCompatDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loader,container,false);
    }

    public static LoaderDialog getInstance() {
        return new LoaderDialog();
    }
}
