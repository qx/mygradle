package com.lenovo.powersetting.entity;

import java.util.Date;
import java.util.Map;


/**
 * Old product
 * 往期凑份商品
 */
public class OldProduct extends Product {
    /**
     * 幸运号
     */
    public int number_lucky;
    /**
     * 揭晓时间
     */
    public Date time_lucky;
    /**
     * 用户--凑份数 MAP
     */
    public Map<User, ActionScore> user_action_map;
}
