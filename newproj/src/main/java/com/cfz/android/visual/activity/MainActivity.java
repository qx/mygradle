package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

public class MainActivity extends BaseActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected String getActivityTitle() {
        return getResources().getString(R.string.app_name);
    }
}
