package io.arfirman1402.dev.iakadvancedbatch3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_test)
    TextView txtTest;

    private Subscription subscriber = new CompositeSubscription();
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prosesData();
    }

    private void prosesData() {
        Observable<String> dataStr = Observable.just("Indonesia", "Raya");

        subscriber = dataStr.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError, this::onCompleted);
    }

    private void onSuccess(String s) {
        Log.d(TAG, "onNext: " + s);
        txtTest.setText(s);
    }

    private void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.toString());
    }

    private void onCompleted() {
        Log.d(TAG, "onCompleted: Has Reached");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }
}