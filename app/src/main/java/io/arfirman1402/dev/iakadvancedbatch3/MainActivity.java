package io.arfirman1402.dev.iakadvancedbatch3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

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
    private ArrayList<String> dataString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prosesData();
    }

    private void prosesData() {
        Observable<String[]> dataStr = Observable.just(new String[]{"Indonesia", "Raya"}, new String[]{"Merdeka", "Merdeka"});

        subscriber = dataStr.map(strings -> {
            StringBuilder sb = new StringBuilder();
            for (String s : strings) {
                sb.append(s + " ");
            }
            return sb.toString();
        }).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverMain()::onSuccess, new ObserverMain()::onError, new ObserverMain()::onCompleted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }

    private class ObserverMain {
        private void onSuccess(String s) {
            Log.d(TAG, "onNext: " + s);
            dataString.add(s);
            txtTest.setText(s);
        }

        private void onError(Throwable e) {
            Log.e(TAG, "onError: " + e.toString());
        }

        private void onCompleted() {
            Log.d(TAG, "onCompleted: Has Reached");
            StringBuilder sb = new StringBuilder();
            for (String s : dataString) {
                sb.append(s);
            }
            txtTest.setText(sb.toString());
        }
    }
}