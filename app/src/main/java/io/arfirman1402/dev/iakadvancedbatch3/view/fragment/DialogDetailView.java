package io.arfirman1402.dev.iakadvancedbatch3.view.fragment;

import io.arfirman1402.dev.iakadvancedbatch3.model.fragment.DialogDetailModelImplement;

/**
 * Created by alodokter-it on 14/05/17 -- DialogDetailView.
 */

public interface DialogDetailView {
    void onSuccess(DialogDetailModelImplement result);

    void onError(Throwable error);

    void onCompleted();
}
