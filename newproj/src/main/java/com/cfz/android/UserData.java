package com.cfz.android;

import com.cfz.android.impl.Notifier;
import com.cfz.android.impl.UserDataChangeListener;
import com.cfz.android.utils.LogUtil;

import java.util.ArrayList;

/**
 * Created by ok on 5/26/14.
 */
public class UserData extends BaseClass implements Notifier{
    private static UserData ourInstance = new UserData();
    public boolean isLogin;

    private String userImage;
    private Integer userintegral;
    private Float userMoney;
    private String userNickName;
    private String userUserId;

    public synchronized static UserData getInstance() {
        return ourInstance;
    }

    private UserData() {
        dataUserlist = new ArrayList<UserDataChangeListener>();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
        notifyAllObservers("userImage",userImage.toString());
    }

    public void setUserintegral(Integer userintegral) {
        this.userintegral = userintegral;
        notifyAllObservers("userintegral",userintegral.toString());
    }

    public Integer getUserintegral() {
        return userintegral;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
        notifyAllObservers("userMoney",userMoney.toString());
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
        notifyAllObservers("UserNickName",this.userNickName);
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
        notifyAllObservers("UserId",this.userUserId);
    }

    public String getUserUserId() {
        return userUserId;
    }


    private ArrayList<UserDataChangeListener> dataUserlist;

    @Override
    public void registerObserver(UserDataChangeListener o) {
        dataUserlist.add(o);
    }

    @Override
    public void removeObserver(UserDataChangeListener o) {
        dataUserlist.remove(o);
    }

    @Override
    public void notifyAllObservers(String key, String value) {
        LogUtil.i(USERDATA, "UserDataUser set " + key + ",value:" + value);
        for (UserDataChangeListener o : dataUserlist) {
            o.update(this);
        }
    }
}
