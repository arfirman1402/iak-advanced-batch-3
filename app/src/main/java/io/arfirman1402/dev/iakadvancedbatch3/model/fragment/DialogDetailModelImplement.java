package io.arfirman1402.dev.iakadvancedbatch3.model.fragment;

import io.arfirman1402.dev.iakadvancedbatch3.util.Urls;
import okhttp3.Request;

/**
 * Created by alodokter-it on 14/05/17 -- DialogDetailModelImplement.
 */

public class DialogDetailModelImplement implements DialogDetailModel {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private int id;
        private String name;
        private String position;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    @Override
    public Request build(String id) {
        return new Request.Builder().get().url(Urls.getDetailURL(id)).build();
    }
}