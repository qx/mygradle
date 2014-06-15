package com.cfz.android.impl;

/**
 * Created by ok on 14-6-15.
 */
public interface Notifier {
    public void registerObserver(UserDataChangeListener o);

    public void removeObserver(UserDataChangeListener o);
//    public void notifyAllObservers();

    public void notifyAllObservers(String key, String value);
}
