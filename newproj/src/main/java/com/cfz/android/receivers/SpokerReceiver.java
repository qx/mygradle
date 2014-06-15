package com.cfz.android.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cfz.android.SpokeAdapter;
import com.cfz.android.constant.IntentConstant;

/**
 * Created by ok on 5/29/14.
 */
public class SpokerReceiver extends BroadcastReceiver {
    private SpokeAdapter mSpokeAdapter = null;

    public SpokerReceiver(SpokeAdapter pc) {
        this.mSpokeAdapter = pc;
    }

    public SpokerReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals(IntentConstant.STARTBRIGHTNESS)) {
            mSpokeAdapter.initSmartBrightness();
            return;
        }
        if (action.equals(IntentConstant.STOPBRIGHTNESS)) {
            mSpokeAdapter.destorySmartBrightness();
            return;
        }
        if (action.equals(IntentConstant.STARTCLASSICMODE)) {
            mSpokeAdapter.initClassiMode();
            return;
        }
        if (action.equals(IntentConstant.STOPCLASSICMODE)) {
            mSpokeAdapter.destoryClassiMode();
            return;
        }
        if (action.equals(IntentConstant.STARTIMINGCHANGE)) {
            mSpokeAdapter.initTimingChanged();
            return;
        }
        if (action.equals(IntentConstant.STOPTIMINGCHANGE)) {
            mSpokeAdapter.destoryTimingChanged();
            return;
        }
        if (action.equals(IntentConstant.STARTVMX)) {
            mSpokeAdapter.initVMX();
            return;
        }
        if (action.equals(IntentConstant.STOPVMX)) {
            mSpokeAdapter.destoryVMX();
            return;
        }
        if (action.equals(IntentConstant.STARTSLEEP)) {
            mSpokeAdapter.initSleep();
            return;
        }
        if (action.equals(IntentConstant.STOPTSLEEP)) {
            mSpokeAdapter.destorySleep();
            return;
        }


    }
}
