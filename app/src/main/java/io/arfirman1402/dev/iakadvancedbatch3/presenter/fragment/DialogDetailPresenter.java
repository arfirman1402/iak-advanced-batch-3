package io.arfirman1402.dev.iakadvancedbatch3.presenter.fragment;

import io.arfirman1402.dev.iakadvancedbatch3.model.fragment.DialogDetailModelImplement;
import rx.Observable;

/**
 * Created by alodokter-it on 14/05/17 -- DialogDetailPresenter.
 */

public interface DialogDetailPresenter {
    Observable<DialogDetailModelImplement> getResult(String id);
}
