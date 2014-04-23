package com.pivotallabs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.pivotallabs.MyTester.getValue;
import static com.pivotallabs.MyTester.rmSetNotInBase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by ok on 14-4-16.
 */
public class MyTesterTest {

    @Test
    public void testketValue() {
        assertThat(getValue("nomep"), equalTo(true));
    }


    @Test
    public void testRmSetNotInBase() {
        //mSet TO BE FILTER = [com.android.providers.telephony, com.mediatek.CellConnService,
        // com.mtk.telephony, com.android.stk, com.mediatek.engineermode, com.mediatek.ygps, com.android.phone]
        Set<String> mSet = new HashSet<String>();
        mSet.add("com.android.providers.telephony");
        mSet.add("com.mediatek.CellConnService");
        mSet.add("com.mtk.telephony");
        mSet.add("com.android.stk");
        mSet.add("com.mediatek.engineermode");
        mSet.add("com.mediatek.ygps");
        mSet.add("com.android.phone");

        //[com.lakala.android, com.tmall.wireless, com.baidu.searchbox_lenovo, com.example.internalhidetest,
        // com.baidu.BaiduMap, com.ting.mp3.oemc.android, com.example.powermanagerservicetest, com.zol.android,
        // com.dianping.v1, com.mykj.game.ddz, com.autonavi.xmgd.navigator, edu.umich.PowerTutor,
        // com.letv.android.client, com.sensortest, com.sina.weibo, com.netease.newsreader.activity, com.sohu.sohuvideo
        //  com.example.android.supportv4, com.iyd.reader.ReadingJoy, com.lenovo.test.batterydrain, com.tencent.mtt]
        Set<String> mSet2 = new HashSet<String>();
        mSet2.add("com.sohu.sohuvideo");
        mSet2.add("com.sohu2.sohuvideo");
        mSet2.add("com.sohu3.sohuvideo");
        mSet2.add("com.android.stk");
        mSet2.add("com.mediatek.engineermode");
        mSet2.add("com.sohu4.sohuvideo");
        mSet2.add("com.sohu5.sohuvideo");
        mSet2.add("com.sohu6.sohuvideo");

        Set<String> mSet3 = new HashSet<String>();
        mSet3.add("com.android.stk");
        mSet3.add("com.mediatek.engineermode");
        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));
    }
}
