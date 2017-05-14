package io.arfirman1402.dev.iakadvancedbatch3.presenter.main;

import io.arfirman1402.dev.iakadvancedbatch3.model.main.MainModelImplement;
import rx.Observable;

/**
 * Created by alodokter-it on 14/05/17 -- MainPresenter.
 */

public interface MainPresenter {
    Observable<MainModelImplement> getResult();
}
