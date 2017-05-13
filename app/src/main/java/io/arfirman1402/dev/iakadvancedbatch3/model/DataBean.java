package io.arfirman1402.dev.iakadvancedbatch3.model;

/**
 * Created by alodokter-it on 13/05/17 -- DataBean.
 */

public class DataBean {
    private String nama;
    private int umur;

    public DataBean(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }
}
