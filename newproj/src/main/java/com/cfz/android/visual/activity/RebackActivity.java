package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.MyApplication;
import com.cfz.android.R;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.CommonHelper;
import com.cfz.android.utils.LogUtil;
import com.google.api.client.http.UrlEncodedContent;

import java.util.HashMap;

/**
 * Created by ok on 7/17/14.
 */
public class RebackActivity extends BaseActivity {
    @InjectView(R.id.content)
    EditText sContent;

    @InjectView(R.id.submit)
    Button content;
    private String contentStr;

    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_reback);
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        content.setText("提交");


//        content.setText();
    }

    @OnClick(R.id.submit)
    public void submit(View view) {
        contentStr = sContent.getText().toString();
        if (contentStr == null || contentStr.equals("")) {
            return;
        }
        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put(URL_USER_MESSAGE_MSG, contentStr);
        data.put(URL_USER_MESSAGE_MSG_VI, CommonHelper.getAppVersion(this));
        data.put(URL_USER_MESSAGE_MSG_PT, CommonHelper.getPhoneType(this));
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_USER_MESSAGE, BaseEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onFail() {
                super.onFail();
                ToastUtils.show(RebackActivity.this,"提交失败");
                content.setText("重新提交");
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
//                    BackProductDetailEntity.
                BaseEntity be = (BaseEntity) o;
                ToastUtils.show(RebackActivity.this,"提交成功");

//                if (be.result.size() > 0) {
//                    contentStr = be.result.get(0).allRight;
//                    LogUtil.i(TAG, "return back entity:" + contentStr);
//                    content.setText(contentStr);
//                } else {
//                    LogUtil.i(TAG, "But return back entity is empty:");
//                    content.setText("SAMPLE经过初赛及复赛的比拼，共有12组家庭闪亮亮相本次决赛。在上周复赛结束后，入选决赛的家庭们接受了马兰花儿童艺术团老师们的专业指导及编排。在参赛家庭和指导老师们的精心准备下，呈现了一场温馨充满暖意的演出。很多小选手都是第一次登上如此专业的剧场舞台，但却表现抢眼毫不怯场。最小的表演者方妙一，不足4岁，却已能很娴熟的配合姐姐和妈妈一同演出歌舞《木偶人》，忽而饰演被操纵木偶，忽而演唱动人甜美的歌曲，赢得评委团的阵阵掌声；融入生活情趣的短剧《拖拉女儿和唠叨妈妈》引入了现实家庭教育存在的矛盾给人带来思考；美妙多姿的拉丁舞与可爱的小胖的跆拳道的组合节目《我的童年我做主》激起的不仅是欢乐更有对自己童年的美好回忆。 ");
//                }
                sContent.setText("");
                content.setText("提交");
                LogUtil.i(TAG, o.toString());
            }
        }, data);
//
    }

    @Override
    protected int getActivityTitle() {
        return R.string.more_advice;
    }
}