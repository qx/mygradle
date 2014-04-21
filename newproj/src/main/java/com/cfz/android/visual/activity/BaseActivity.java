package com.cfz.android.visual.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/21.
 */
public class BaseActivity extends Activity {
    protected TextView title;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = (TextView) findViewById(R.id.title);
    }

    /**
     * reset title text
     *
     * @param titlestr
     */
    protected void setActivityTitle(String titlestr) {
        if (title != null) {
            title.setText(titlestr);
        }
    }
}