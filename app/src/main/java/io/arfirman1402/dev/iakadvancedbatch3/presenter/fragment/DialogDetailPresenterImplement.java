package io.arfirman1402.dev.iakadvancedbatch3.presenter.fragment;

import com.google.gson.GsonBuilder;

import io.arfirman1402.dev.iakadvancedbatch3.model.fragment.DialogDetailModel;
import io.arfirman1402.dev.iakadvancedbatch3.model.fragment.DialogDetailModelImplement;
import io.arfirman1402.dev.iakadvancedbatch3.util.OkHttpTime;
import io.arfirman1402.dev.iakadvancedbatch3.util.RxOkhttp;
import io.arfirman1402.dev.iakadvancedbatch3.view.fragment.DialogDetailView;
import okhttp3.Request;
import rx.Observable;

/**
 * Created by alodokter-it on 14/05/17 -- DialogDetailPresenterImplement.
 */

public class DialogDetailPresenterImplement implements DialogDetailPresenter {
    DialogDetailModel model;
    DialogDetailView view;

    public DialogDetailPresenterImplement(DialogDetailView view) {
        model = new DialogDetailModelImplement();
        this.view = view;
    }

    @Override
    public Observable<DialogDetailModelImplement> getResult(String id) {
        Request request = model.build(id);
        return RxOkhttp.streamStrings(OkHttpTime.client, request)
                .map(json -> new GsonBuilder().create().fromJson(json, DialogDetailModelImplement.class));
    }
}
