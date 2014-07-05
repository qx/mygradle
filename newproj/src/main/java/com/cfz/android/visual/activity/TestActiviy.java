package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.View;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.Spokers;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.protobuf.ProtoHttpContent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ok on 7/5/14.
 */
public class TestActiviy extends BaseActivity implements URLConstant , View.OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        testUrl();
    }

    private void testUrl() {
        ToastUtils.show(TestActiviy.this, "touch");
        testMethod();
    }

    private void testMethod() {
//            inputstream = new FileInputStream(tempfile);
//            HttpContent imc = new InputStreamContent("image/jpeg", inputstream);
            HttpContent httpContent = new HttpContent() {
                @Override
                public long getLength() throws IOException {
                    return 0;
                }

                @Override
                public String getEncoding() {
                    return null;
                }

                @Override
                public String getType() {
                    return null;
                }

                @Override
                public void writeTo(OutputStream outputStream) throws IOException {

                }

                @Override
                public boolean retrySupported() {
                    return false;
                }
            };
//
//            "1：advId
//            2：advImg
//            3：advType       "
            Spokers.getInstance().postHttpDataUseAsync(httpContent, new HttpRequestListener() {
                @Override
                public void onDoing() {
                    super.onDoing();
                }

                @Override
                public void onSuccess(Object o) {
                    ToastUtils.show(TestActiviy.this, "success");
                    super.onSuccess(o);
                }

                @Override
                public void onFail() {
                    ToastUtils.show(TestActiviy.this, "fail");
                    super.onFail();
                }
            }, GET_PRODUCT_URL, BaseEntity.class);
    }

    @Override
    public void onClick(View v) {
        ToastUtils.show(TestActiviy.this, "fail");
        testUrl();
    }
}