package mavliwala.nazmuddin.zoloassignment.profile.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import butterknife.OnClick;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.profile.di.EditProfileModule;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.EditProfilePresenter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

import static mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity.USER;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class EditProfileActivity extends BaseActivity implements EditProfileView {

    @Inject
    EditProfilePresenter presenter;

    @BindViews({
            R.id.et_mobile,
            R.id.et_email,
            R.id.et_name
    })
    List<EditText> editTexts;
    private UserVO user;

    @OnClick(R.id.bt_update)
    public void onUpdateClick() {
        this.presenter.update(getUserVO());
    }

    private UserVO getUserVO() {
        if (user != null) {
            user.setMobile(getValue(R.id.et_mobile));
            user.setEmail(getValue(R.id.et_email));
            user.setName(getValue(R.id.et_name));
            return user;
        }
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideEditProfileComponent(new EditProfileModule(this))
                .inject(this);
        this.user = Parcels.unwrap(getIntent().getParcelableExtra(USER));
        bind();
    }

    private void bind() {
        if (this.user != null) {
            EditText etName = finView(R.id.et_name);
            etName.setText(user.getName());

            EditText etMobile = finView(R.id.et_mobile);
            etMobile.setText(user.getMobile());

            EditText etEmail = finView(R.id.et_email);
            etEmail.setText(user.getEmail());
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void returnUpdatedProfile(UserVO userVO) {
        Intent intent = getIntent();
        intent.putExtra(USER, Parcels.wrap(userVO));
        setResult(RESULT_OK,intent);
        finish();
    }
}
