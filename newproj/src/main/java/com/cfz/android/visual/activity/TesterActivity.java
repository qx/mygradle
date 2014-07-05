package com.cfz.android.visual.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.Spokers;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.BackAdvListEntity;
import com.cfz.android.entity.network.urlentity.BackJinRiEntity;
import com.cfz.android.entity.network.urlentity.BackListProductEntity;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.UrlEncodedContent;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Created by Administrator on 2014/4/24.
 */
public class TesterActivity extends Activity implements URLConstant, View.OnClickListener {
    private Button guanggao;
    private Button huodong;
    private Button jinri;
    private Button deng;

    private Button lishi;
    private Button xiangqing;
    private Button tongkuan;
    private Button jilu;

    private Button coufeng;
    private Button gengduo;
    private Button yijian;
    private Button gengxin;

    private Button zhuce;
    private Button zijinchi;
    private Button yonghu;
    private Button nicheng;

    private Button dizhi;
    private Button shezhidizhi;
    private Button shangpinpinglun;
    private Button pinglun;
    private HttpContent httpContent;

    private HashMap<String, Object> data=new HashMap<String, Object>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tester);
//        setContentView(R.layout.activity_account_deatail_list);
//        setContentView(R.layout.activity_address);
//        setContentView(R.layout.activity_address_add);
//        setContentView(R.layout.activity_edit_usericon);
//        setContentView(R.layout.activity_main_last);
//        setContentView(R.layout.activity_main_product);
//        setContentView(R.layout.activity_message_add);
//        setContentView(R.layout.activity_more);
//        setContentView(R.layout.activity_pay_score);
//        setContentView(R.layout.activity_payout);
//        setContentView(R.layout.activity_product_bestuser);
//        setContentView(R.layout.activity_product_detail);
//        setContentView(R.layout.activity_product_explain);
//        setContentView(R.layout.activity_pwd_find);
//        setContentView(R.layout.activity_product_get);
//        setContentView(R.layout.activity_product_message);
//        setContentView(R.layout.activity_product_other_scores);
//        setContentView(R.layout.activity_register);
//        setContentView(R.layout.activity_score_payout);
//        setContentView(R.layout.activity_share);
//        setContentView(R.layout.activity_user_account_payin);
//        setContentView(R.layout.activity_user_all);
//        setContentView(R.layout.activity_user_edit);
//        setContentView(R.layout.activity_user_get);
//        setContentView(R.layout.activity_user_loading);
//        setContentView(R.layout.activity_user_name);
        setContentView(R.layout.activity_tester);

        guanggao = (Button) (findViewById(R.id.guanggao));
        guanggao.setOnClickListener(this);
        huodong = (Button) (findViewById(R.id.huodong));
        huodong.setOnClickListener(this);
        jinri = (Button) (findViewById(R.id.jinri));
        jinri.setOnClickListener(this);
        deng = (Button) (findViewById(R.id.deng));
        deng.setOnClickListener(this);


        lishi = (Button) (findViewById(R.id.lishi));
        lishi.setOnClickListener(this);
        xiangqing = (Button) (findViewById(R.id.xiangqing));
        xiangqing.setOnClickListener(this);
        tongkuan = (Button) (findViewById(R.id.tongkuan));
        tongkuan.setOnClickListener(this);
        jilu = (Button) (findViewById(R.id.jilu));
        jilu.setOnClickListener(this);


        coufeng = (Button) (findViewById(R.id.coufeng));
        coufeng.setOnClickListener(this);
        yijian = (Button) (findViewById(R.id.yijian));
        yijian.setOnClickListener(this);
        gengduo = (Button) (findViewById(R.id.gengduo));
        gengduo.setOnClickListener(this);
        gengxin = (Button) (findViewById(R.id.gengxin));
        gengxin.setOnClickListener(this);


        zhuce = (Button) (findViewById(R.id.zhuce));
        zhuce.setOnClickListener(this);
        zijinchi = (Button) (findViewById(R.id.zijinchi));
        zijinchi.setOnClickListener(this);
        yonghu = (Button) (findViewById(R.id.yonghu));
        yonghu.setOnClickListener(this);
        nicheng = (Button) (findViewById(R.id.nicheng));
        nicheng.setOnClickListener(this);


        dizhi = (Button) (findViewById(R.id.dizhi));
        dizhi.setOnClickListener(this);
        shezhidizhi = (Button) (findViewById(R.id.shezhidizhi));
        shezhidizhi.setOnClickListener(this);
        shangpinpinglun = (Button) (findViewById(R.id.shangpinpinglun));
        shangpinpinglun.setOnClickListener(this);
        pinglun = (Button) (findViewById(R.id.pinglun));
        pinglun.setOnClickListener(this);


//        httpContent = new UrlEncodedContent();
//                httpContent = new HttpContent() {
//            @Override
//            public long getLength() throws IOException {
//                return 0;
//            }
//
//            @Override
//            public String getEncoding() {
//                return null;
//            }
//
//            @Override
//            public String getType() {
//                return null;
//            }
//
//            @Override
//            public void writeTo(OutputStream outputStream) throws IOException {
//
//            }
//
//            @Override
//            public boolean retrySupported() {
//                return false;
//            }
//        };

//        testUrl();

    }

    private void testUrl() {
        ToastUtils.show(TesterActivity.this, "touch");
        testMethod(URL_ADS, BackAdvListEntity.class, httpContent);
    }


    /**
     * 接口测试
     *
     * @param Url        完整URL地址
     * @param backentity 返回封装类
     * @param content    内容
     */
    public static void testMethod(String Url, Class<? extends BaseEntity> backentity, HttpContent content) {
        Spokers.getInstance().postHttpDataUseAsync(content, new HttpRequestListener() {
            @Override
            public void onDoing() {
                super.onDoing();
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
            }

            @Override
            public void onFail() {
                super.onFail();
            }
        }, Url, backentity);
//        }, URL_ADS, BackAdvListEntity.class);
    }

    @Override
    public void onClick(View v) {
//        testUrl();
        switch (v.getId()) {
            case R.id.guanggao:
//                ToastUtils.show(TesterActivity.this, "guanggao");
                httpContent = new HttpContent() {
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

                testMethod(URL_ADS, BackAdvListEntity.class, httpContent);
//                testMethod(URL_ADS, BackAdvListEntity.class, httpContent);

                break;
            case R.id.huodong:
//                ToastUtils.show(TesterActivity.this, "huodong");
                testMethod(PRODUCT_URL, BackListProductEntity.class, httpContent);
                break;
            case R.id.jinri:
//                ToastUtils.show(TesterActivity.this, "jinri");
                data.put(PARAMS_JINRI, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_JINRI, BackJinRiEntity.class, httpContent);
                break;
            case R.id.deng:
//                ToastUtils.show(TesterActivity.this, "deng");
                testMethod(PRODUCT_URL, BackListProductEntity.class, httpContent);
                break;


            case R.id.lishi:
                ToastUtils.show(TesterActivity.this, "lishi");
                break;
            case R.id.xiangqing:
                ToastUtils.show(TesterActivity.this, "xiangqing");
                break;
            case R.id.tongkuan:
                ToastUtils.show(TesterActivity.this, "tongkuan");
                break;
            case R.id.jilu:
                ToastUtils.show(TesterActivity.this, "jilu");
                break;


            case R.id.coufeng:
                ToastUtils.show(TesterActivity.this, "coufeng");
                break;
            case R.id.gengduo:
                ToastUtils.show(TesterActivity.this, "gengduo");
                break;
            case R.id.yijian:
                ToastUtils.show(TesterActivity.this, "yijian");
                break;
            case R.id.gengxin:
                ToastUtils.show(TesterActivity.this, "gengxin");
                break;


            case R.id.zhuce:
                ToastUtils.show(TesterActivity.this, "zhuce");
                break;
            case R.id.zijinchi:
                ToastUtils.show(TesterActivity.this, "zijinchi");
                break;
            case R.id.yonghu:
                ToastUtils.show(TesterActivity.this, "yonghu");
                break;
            case R.id.nicheng:
                ToastUtils.show(TesterActivity.this, "nicheng");
                break;


        }
    }
}