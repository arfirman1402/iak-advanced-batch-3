package io.arfirman1402.dev.iakadvancedbatch3.view.main;

import android.os.Bundle;
import android.util.Log;

import io.arfirman1402.dev.iakadvancedbatch3.R;
import io.arfirman1402.dev.iakadvancedbatch3.base.BaseActivity;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.main.MainPresenter;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.main.MainPresenterImplement;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        mainPresenter = new MainPresenterImplement(this);
        subscriber = mainPresenter.getResult().observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(this::onSuccess, this::onError, this::onCompleted);
    }

    @Override
    public void onSuccess(String result) {
        Log.d(TAG, "onSuccess: " + result);

    }

    @Override
    public void onError(Throwable error) {
        Log.e(TAG, "onError: " + error.toString());
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: Has Reached");
    }
}