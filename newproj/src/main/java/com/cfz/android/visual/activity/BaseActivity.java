package com.cfz.android.visual.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/21.
 */
public class BaseActivity extends Activity {
    protected TextView title;


    @Override
    protected void onResume() {
        super.onResume();
        title = (TextView) findViewById(R.id.title);
        if (title != null) {
            title.setText(getActivityTitle());
        }
    }

    public void onReturn(View view) {
        if (view != null) {
            this.finish();
        }
    }

    /**
     * reset title text
     */
    protected String getActivityTitle() {
        return null;
    }
}