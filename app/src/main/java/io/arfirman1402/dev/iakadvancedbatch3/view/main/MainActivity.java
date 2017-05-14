package io.arfirman1402.dev.iakadvancedbatch3.view.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import io.arfirman1402.dev.iakadvancedbatch3.R;
import io.arfirman1402.dev.iakadvancedbatch3.adapter.ListAdapter;
import io.arfirman1402.dev.iakadvancedbatch3.base.BaseActivity;
import io.arfirman1402.dev.iakadvancedbatch3.holder.MainListHolder;
import io.arfirman1402.dev.iakadvancedbatch3.model.main.MainModelImplement;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.main.MainPresenter;
import io.arfirman1402.dev.iakadvancedbatch3.presenter.main.MainPresenterImplement;
import io.arfirman1402.dev.iakadvancedbatch3.view.fragment.DialogDetail;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mainPresenter;
    private String TAG = this.getClass().getSimpleName();
    private ListAdapter listAdapter;

    @BindView(R.id.main_rv)
    public RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        mainPresenter = new MainPresenterImplement(this);
        subscriber = mainPresenter.getResult()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(this::onSuccess, this::onError, this::onCompleted);
    }

    @Override
    public void onSuccess(MainModelImplement result) {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        listAdapter = new ListAdapter<MainModelImplement.Data, MainListHolder>(R.layout.adapter_main_rv, MainListHolder.class, MainModelImplement.Data.class, result.getData()) {
            @Override
            protected void bindView(MainListHolder holder, MainModelImplement.Data model, int position) {
                holder.bind(model.getName());
                holder.itemView.setOnClickListener(v -> {
                    DialogDetail detail = new DialogDetail();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(model.getId()));
                    detail.setArguments(bundle);
                    detail.show(getSupportFragmentManager(), "Detail");
                });
            }
        };

        mainRecyclerView.setAdapter(listAdapter);
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