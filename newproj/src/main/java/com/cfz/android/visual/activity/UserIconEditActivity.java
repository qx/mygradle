package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cfz.android.R;
import com.cfz.android.UserData;
import com.cfz.android.visual.imageutils.ImageLoader;

/**
 * Created by Administrator on 2014/4/27.
 */
public class UserIconEditActivity extends BaseActivity implements View.OnClickListener {
    private EditText v_value;
    private LinearLayout title_right_click;
    private ImageView user_img;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usericon);
        v_value = (EditText) findViewById(R.id.v_value);
        user_img = (ImageView) findViewById(R.id.user_img);
        title_right_click = (LinearLayout) findViewById(R.id.title_right_click);
        title_right_click.setOnClickListener(this);

        initView();
    }

    private void initView() {
        v_value.setText(UserData.getInstance().getUserNickName());
        ImageLoader imageLoader = new ImageLoader(this.getApplicationContext());
        imageLoader.DisplayImage(UserData.getInstance().getUserImage(), user_img);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_edit_userpic;
    }

    @Override
    protected int getActivityMoreImg() {
        return R.drawable.save;
    }

    @Override
    protected int getActivityMoreTitle() {
        return R.string.null_string;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_right_click:
                saveToServer();
                break;
            default:
                break;
        }
    }

    private void saveToServer() {
        //TODO
    }
}