package com.lenovo.powersetting;

/**
 * Created by ok on 5/26/14.
 */
public class UserData {
    private static UserData ourInstance = new UserData();
    public boolean isLogin;

    public synchronized static UserData getInstance() {
        return ourInstance;
    }

    private UserData() {
    }
}
