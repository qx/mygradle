package com.cfz.android.entity.data;

import java.util.List;

/**
 * Account Information
 * 账户明细
 */
public class AccountInfo {
    /**
     * 入账明细列表
     */
    public List<AccountIn> accountIns;
    /**
     * 出账明细列表
     */
    public List<AccountOut> accountOuts;
}