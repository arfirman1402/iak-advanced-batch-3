package io.arfirman1402.dev.iakadvancedbatch3.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by alodokter-it on 13/05/17 -- BaseActivity.
 */

public class BaseActivity extends AppCompatActivity {
    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void openNewActivity(Class dest) {
        Intent i = new Intent(this, dest);
        startActivity(i);
        finish();
    }
}