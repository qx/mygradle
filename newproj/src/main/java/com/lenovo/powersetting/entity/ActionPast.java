package com.lenovo.powersetting.entity;

import java.util.Map;

/**
 * The past action info
 * 往期凑份信息
 */
public class ActionPast {
    /**
     * user-action
     * 用户-凑份数
     */
    public Map<User, ActionScore> user_action_map;
}
