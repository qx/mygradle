package com.cfz.android.mode.object;

import java.util.Map;

/**
 * The Action Doing.
 * 当前活动
 */
public class ActionCurrent {
    /**
     * current action progress;
     * 当前凑份数
     */
    public int action_current;
    /**
     * the max num for product
     * 产品最大凑份数
     */
    public int action_max;

    /**
     * 用户,凑份信息Map
     */
    public Map<User, ActionScore> userActionScoreMap;

}
