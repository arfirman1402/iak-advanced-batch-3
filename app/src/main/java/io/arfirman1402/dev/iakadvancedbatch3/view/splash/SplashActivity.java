package io.arfirman1402.dev.iakadvancedbatch3.view.splash;

import android.content.Intent;
import android.os.Bundle;

import io.arfirman1402.dev.iakadvancedbatch3.MainActivity;
import io.arfirman1402.dev.iakadvancedbatch3.R;
import io.arfirman1402.dev.iakadvancedbatch3.base.BaseActivity;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.splash.SplashPresenter;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.splash.SplashPresenterImplement;

public class SplashActivity extends BaseActivity implements SplashView {

    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);

        splashPresenter = new SplashPresenterImplement(this);
        splashPresenter.waitSplash(5000);
    }

    @Override
    public void showAlert() {
        showToast("Hai, Wassap brohh !!!");
    }

    @Override
    public void openMain() {
        openNewActivity(MainActivity.class);
    }
}
