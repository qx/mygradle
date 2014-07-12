package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.RequestInsance;
import com.cfz.android.Spokers;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.*;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.UrlEncodedContent;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * adb logcat time -v | grep -E "netTransfer|fatal exception" -i
 */
public class TesterActivity extends BaseActivity implements URLConstant, View.OnClickListener {
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
    @InjectView(R.id.requestUrl)
    TextView requestUrl;
    @InjectView(R.id.backInfo)
    TextView backInfo;
    private HashMap<String, Object> data = new HashMap<String, Object>();

    public void onCreate(Bundle savedInstanceState) {

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
        super.onCreate(savedInstanceState);
//        ButterKnife.inject(this);
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
        yonghu = (Button) (findViewById(R.id.usericon));
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
        testMethod(URL_ADS, BackAdvListEntity.class, httpContent, data);
    }


    /**
     * 接口测试
     *
     * @param Url        完整URL地址
     * @param backentity 返回封装类
     * @param content    内容
     */
    private void testMethod(String Url, Class<? extends BaseEntity> backentity, HttpContent content, final HashMap<String, Object> data) {
        Spokers.getInstance().postHttpDataUseAsync(content, new HttpRequestListener() {
            @Override
            public void onPre() {
                super.onPre();
//                LogUtil.i(TAG, ToStringBuilder.reflectionToString(data));
                LogUtil.logNet("params:"+data.toString());

            }

            @Override
            public void onDoing() {
                super.onDoing();
            }

            @Override
            public void onPost() {
                super.onPost();
                requestUrl.setText(RequestInsance.getInstance().getRequrl());
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                backInfo.setText(RequestInsance.getInstance().getBackinfo());
            }

            @Override
            public void onFail() {
                super.onFail();
                backInfo.setText(RequestInsance.getInstance().getBackinfo());
            }
        }, Url, backentity);
    }

    @Override
    public void onClick(View v) {
        if (data == null) {
            return;
        }
        data.clear();
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

                testMethod(URL_ADS, BackAdvListEntity.class, httpContent, data);
//                testMethod(URL_ADS, BackAdvListEntity.class, httpContent);

                break;
            case R.id.huodong:
//                ToastUtils.show(TesterActivity.this, "huodong");
                testMethod(URL_PRODUCTING, BackListProductEntity.class, httpContent, data);
                break;
            case R.id.jinri:
                data.put(URL_LOTTERY_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_LOTTERY, BackJinRiEntity.class, httpContent, data);
                break;
            case R.id.deng:
                data.put(URL_WAITING_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_WAITING, BackWaitingEntity.class, httpContent, data);
                break;


            case R.id.lishi:
                data.put(URL_HISTORY_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_HISTORY, BackHistoryEntity.class, httpContent, data);
                break;
            case R.id.xiangqing:
                data.put(URL_PRODUCT_DETAIL_PID, "4028ce8145a8dd330145a8de2c3c0001");//商品ID未知
                data.put(URL_PRODUCT_DETAIL_IID, "abc3d9da7d9f0a6d0a1209dajdfe7a1e");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_PRODUCT_DETAIL, BackProductDetailEntity.class, httpContent, data);
                break;
            case R.id.tongkuan:
                data.put(URL_PRODUCT_SAME_PN, 1);
                data.put(URL_PRODUCT_SAME_IID, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_PRODUCT_SAME, BackSameWinnerEntity.class, httpContent, data);
                break;
            case R.id.jilu:
                data.put(URL_PRODUCT_RECORD_PID, 1);
                data.put(URL_PRODUCT_RECORD_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_PRODUCT_RECORD, BackPdRecorderEntity.class, httpContent, data);
                break;


            case R.id.coufeng:
                data.put(URL_USER_BET_PID, 1);
                data.put(URL_USER_BET_BN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_BET, BackBetEntity.class, httpContent, data);
                break;
            case R.id.gengduo:
//                data.put(URL_MORE, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_MORE, BackMoreEntity.class, httpContent, data);
                break;
            case R.id.yijian:
                data.put(URL_USER_MESSAGE_MSG, "服务器真给力");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_MESSAGE, BaseEntity.class, httpContent, data);
                break;
            case R.id.gengxin:
//                data.put(URL_LOTTERY_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_LOTTERY, BaseEntity.class, httpContent, data);
                break;


            case R.id.zhuce:
                data.put(URL_LOADING_QQID, "afser23478123947123");
                data.put(URL_LOADING_PT, 1);
                data.put(URL_LOADING_PSN, "2123341232fEW3");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_LOTTERY, BackUserLoadEntity.class, httpContent, data);
                break;
            case R.id.zijinchi:
//                data.put(URL_USER_COUNT_REF, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_COUNT, BaseEntity.class, httpContent, data);
                break;
            case R.id.usericon:
                data.put(URL_USER_ICON_SET, "9527");// 此处需要修改成文件
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_ICON, BaseEntity.class, httpContent, data);
                break;
            case R.id.nicheng:
                data.put(URL_USER_NICK_SET, "9527");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_NICK, BaseEntity.class, httpContent, data);
                break;


//
            case R.id.dizhi:
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_ADDRESS, BaseEntity.class, httpContent, data);
                break;
            case R.id.shezhidizhi:
                data.put(URL_USER_SETADDRESS_AD, "american white house");
                data.put(URL_USER_SETADDRESS_CN, "newyork");
                data.put(URL_USER_SETADDRESS_PH, "110");
                data.put(URL_USER_SETADDRESS_REAL, "中国人民解放军");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_USER_SETADDRESS, BaseEntity.class, httpContent, data);
                break;
            case R.id.shangpinpinglun:
                data.put(URL_COMMENT_GET_PID, "什么乱七八糟的");
                data.put(URL_COMMENT_GET_PN, 1);
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_COMMENT_GET, BackProductCommentEntity.class, httpContent, data);
                break;
            case R.id.pinglun:
                data.put(URL_COMMENT_SET_CON, "URL_COMMENT_SET_CON");
                data.put(URL_COMMENT_SET_UID, "URL_COMMENT_SET_UID");
                data.put(URL_COMMENT_SET_PID, "URL_COMMENT_SET_PID");
                httpContent = new UrlEncodedContent(data);
                testMethod(URL_COMMENT_SET, BaseEntity.class, httpContent, data);
                break;


        }
    }
}