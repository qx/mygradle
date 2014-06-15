package com.cfz.android;

/**
 * Created by ok on 5/26/14.
 */
public class UserData {
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
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setUserintegral(Integer userintegral) {
        this.userintegral = userintegral;
    }

    public Integer getUserintegral() {
        return userintegral;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
    }

    public String getUserUserId() {
        return userUserId;
    }
}
