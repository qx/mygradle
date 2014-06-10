package com.lenovo.powersetting.visual.activity;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lenovo.powersetting.R;
import com.lenovo.powersetting.visual.activity.listener.SecondClickListener;

/**
 * Created by Administrator on 2014/4/21.
 */
public class BaseActivity extends FragmentActivity implements SecondClickListener{
    protected TextView title;
    protected TextView title2;
    protected ImageView img;


    @Override
    protected void onResume() {
        super.onResume();
        title = (TextView) findViewById(R.id.title);
        if (title != null) {
            title.setText(getActivityTitle());
        }
        title2 = (TextView) findViewById(R.id.title_txt_more);
        if (title2 != null) {
            title2.setText(getActivityMoreTitle());
        }
        img = (ImageView) findViewById(R.id.title_img_more);
        if (img != null) {
            img.setImageResource(getActivityMoreImg());
        }


    }

    /**
     * @return resid
     */
    protected int getActivityMoreImg() {
        return 0;
    }

    /**
     * @return resid
     */
    protected int getActivityMoreTitle() {
        return 0;
    }

    public void onReturn(View view) {
        if (view != null) {
            this.finish();
        }
    }

    public void onSecondClick(View view) {
        if (view != null) {
            secondClick();
        }
    }

    /**
     * @return resid
     */
    protected int getActivityTitle() {
        return 0;
    }

    @Override
    public void secondClick() {
    }

}