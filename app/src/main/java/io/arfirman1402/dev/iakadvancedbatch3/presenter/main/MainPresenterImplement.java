package io.arfirman1402.dev.iakadvancedbatch3.presenter.main;

import io.arfirman1402.dev.iakadvancedbatch3.model.main.MainModel;
import io.arfirman1402.dev.iakadvancedbatch3.model.main.MainModelImplement;
import io.arfirman1402.dev.iakadvancedbatch3.util.OkHttpTime;
import io.arfirman1402.dev.iakadvancedbatch3.util.RxOkhttp;
import io.arfirman1402.dev.iakadvancedbatch3.view.main.MainView;
import okhttp3.Request;
import rx.Observable;

/**
 * Created by alodokter-it on 14/05/17 -- MainPresenterImplement.
 */

public class MainPresenterImplement implements MainPresenter {
    MainModel model;
    MainView view;

    public MainPresenterImplement(MainView view) {
        model = new MainModelImplement();
        this.view = view;
    }

    @Override
    public Observable<String> getResult() {
        Request request = model.build();
        return RxOkhttp.streamStrings(OkHttpTime.client, request);
    }
}