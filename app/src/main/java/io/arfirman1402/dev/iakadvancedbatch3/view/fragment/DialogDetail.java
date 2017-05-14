package io.arfirman1402.dev.iakadvancedbatch3.view.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.arfirman1402.dev.iakadvancedbatch3.R;
import io.arfirman1402.dev.iakadvancedbatch3.model.fragment.DialogDetailModelImplement;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.fragment.DialogDetailPresenterImplement;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alodokter-it on 14/05/17 -- DialogDetail.
 */

public class DialogDetail extends DialogFragment implements DialogDetailView {
    @BindView(R.id.txt_name)
    TextView txtName;

    @BindView(R.id.txt_position)
    TextView txtPosition;

    private Subscription subscriber = new CompositeSubscription();
    private String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detail, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String id = getArguments().getString("id");
        subscriber = new DialogDetailPresenterImplement(this).getResult(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::onSuccess, this::onError, this::onCompleted);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }

    @Override
    public void onSuccess(DialogDetailModelImplement result) {
        txtName.setText(result.getData().getName());
        txtPosition.setText(result.getData().getPosition());
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
