package io.arfirman1402.dev.iakadvancedbatch3.view.main;

import io.arfirman1402.dev.iakadvancedbatch3.model.main.MainModelImplement;

/**
 * Created by alodokter-it on 14/05/17 -- MainView.
 */

public interface MainView {
    void onSuccess(MainModelImplement result);

    void onError(Throwable error);

    void onCompleted();
}
