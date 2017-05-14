package io.arfirman1402.dev.iakadvancedbatch3.model.main;

import java.util.ArrayList;

import io.arfirman1402.dev.iakadvancedbatch3.util.Urls;
import okhttp3.Request;

/**
 * Created by alodokter-it on 14/05/17 -- MainModelImplement.
 */

public class MainModelImplement implements MainModel {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public Request build() {
        return new Request.Builder().get().url(Urls.getMainUrl()).build();
    }
}