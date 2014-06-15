package com.cfz.android;

import com.cfz.android.impl.Notifier;
import com.cfz.android.impl.UserDataChangeListener;
import com.cfz.android.utils.LogUtil;

/**
 * Created by ok on 14-6-15.
 */
public class UserDataUser extends BaseClass implements UserDataChangeListener {
    private String userdataUserTag;

    public UserDataUser(String userdataUserTag) {
        this.userdataUserTag = userdataUserTag;
    }

    @Override

    public void update(Notifier s) {
        LogUtil.i(USERDATA,"<"+userdataUserTag+">get UserDataChanged notification:"+ s);
    }
}
