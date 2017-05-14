package io.arfirman1402.dev.iakadvancedbatch3.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.arfirman1402.dev.iakadvancedbatch3.R;

/**
 * Created by alodokter-it on 14/05/17 -- MainListHolder.
 */

public class MainListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txt_name)
    TextView txtName;

    @BindView(R.id.txt_position)
    TextView txtPosition;

    @BindView(R.id.main_item_layout)
    LinearLayout mainItemLayout;

    public MainListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /*public void bind(MainModelImplement.Data data) {
        txtName.setText(data.getName());
        txtPosition.setText("Masih blum ada");
    }*/

    public void bind(String name) {
        txtName.setText(name);
    }
}