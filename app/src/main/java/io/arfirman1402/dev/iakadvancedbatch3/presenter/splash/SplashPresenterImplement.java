package io.arfirman1402.dev.iakadvancedbatch3.presenter.splash;

import android.os.Handler;

import io.arfirman1402.dev.iakadvancedbatch3.view.splash.SplashView;

/**
 * Created by alodokter-it on 13/05/17 -- SplashPresenterImplement.
 */

public class SplashPresenterImplement implements SplashPresenter {
    SplashView view;

    public SplashPresenterImplement(SplashView view) {
        this.view = view;
    }

    @Override
    public void waitSplash(int duration) {
        Handler handler = new Handler();
        Runnable runnable = () -> {
            view.showAlert();
            view.openMain();
        };
        handler.postDelayed(runnable, duration);
    }
}
