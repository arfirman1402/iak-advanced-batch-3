package io.arfirman1402.dev.iakadvancedbatch3.util;

import io.arfirman1402.dev.iakadvancedbatch3.BuildConfig;

/**
 * Created by alodokter-it on 14/05/17 -- Urls.
 */

public class Urls {
    private static final String BASE_URL = BuildConfig.URI;
    private static final String DETAIL_URL = "/detail/";

    public static String getMainUrl() {
        return BASE_URL;
    }

    public static String getDetailURL(String id) {
        return BASE_URL + DETAIL_URL + id;
    }
}
