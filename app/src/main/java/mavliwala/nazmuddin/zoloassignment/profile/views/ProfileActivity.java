package mavliwala.nazmuddin.zoloassignment.profile.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.hendraanggrian.rx.activity.ActivityResult;
import com.hendraanggrian.rx.activity.RxActivity;
import com.jakewharton.rxbinding2.view.RxView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindViews;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import mavliwala.nazmuddin.zoloassignment.R;
import mavliwala.nazmuddin.zoloassignment.base.views.helpers.BaseActivity;
import mavliwala.nazmuddin.zoloassignment.profile.di.ProfileModule;
import mavliwala.nazmuddin.zoloassignment.profile.presenters.ProfilePresenter;
import mavliwala.nazmuddin.zoloassignment.register.models.UserVO;

import static mavliwala.nazmuddin.data.disc.SharedPrefConstants.USER_ID;
import static mavliwala.nazmuddin.zoloassignment.register.views.RegisterActivity.USER;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class ProfileActivity extends BaseActivity implements ProfileView {

    @BindViews({
            R.id.iv_edit_1,
            R.id.iv_edit_2,
            R.id.iv_edit_3
    })
    List<ImageView> imageViews;

    @BindViews({
            R.id.tv_name,
            R.id.tv_mobile,
            R.id.tv_email
    }) List<TextView> textViews;

    @Inject
    ProfilePresenter presenter;
    private UserVO user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().provideProfileComponent(new ProfileModule(this))
                .inject(this);
        bindEditClicks();
        long userId = getIntent().getLongExtra(USER_ID, -1);
        this.presenter.getUser(userId);
    }

    private void bindEditClicks() {
        for (ImageView imageView : imageViews) {
            RxView.clicks(imageView)
                    .filter(new Predicate<Object>() {
                        @Override
                        public boolean test(@NonNull Object o) throws Exception {
                            return user != null;
                        }
                    })
                    .map(new Function<Object, Intent>() {
                        @Override
                        public Intent apply(@NonNull Object o) throws Exception {
                            Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                            intent.putExtra(USER,Parcels.wrap(user));
                            return intent;
                        }
                    })
                    .switchMap(new Function<Intent, ObservableSource<ActivityResult>>() {
                        @Override
                        public ObservableSource<ActivityResult> apply(@NonNull Intent o) throws Exception {
                            return RxActivity.startForResult(ProfileActivity.this,o);
                        }
                    })
                    .filter(new Predicate<ActivityResult>() {
                        @Override
                        public boolean test(@NonNull ActivityResult result) throws Exception {
                            return result.resultCode == RESULT_OK;
                        }
                    })
                    .map(new Function<ActivityResult, UserVO>() {
                        @Override
                        public UserVO apply(@NonNull ActivityResult result) throws Exception {
                            Intent intent = result.data;
                            return Parcels.unwrap(intent.getParcelableExtra(USER));
                        }
                    })
                    .subscribe(new Consumer<UserVO>() {
                        @Override
                        public void accept(@NonNull UserVO userVO) throws Exception {
                            bind(userVO);
                        }
                    });
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_profile;
    }

    @Override
    public void bind(UserVO user) {
        this.user = user;
        //name
        TextView tvName = finView(R.id.tv_name);
        tvName.setText(user.getName());
        //email
        TextView tvEmail = finView(R.id.tv_email);
        tvEmail.setText(user.getEmail());
        //mobile
        TextView tvMobile = finView(R.id.tv_mobile);
        tvMobile.setText(user.getMobile());
    }
}
