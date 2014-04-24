package com.pivotallabs;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by ok on 14-4-16.
 */
public class MyTester {
    public static boolean getValue(String a) {
        return a.length() == 5;
    }



    public static Set<String> rmSetNotInBase(Set<String> mSet, Set<String> pkgListSet) {
        Iterator<String> iterator = mSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (!pkgListSet.contains(element)) {
                iterator.remove();
            }
        }
        return mSet;
    }
}
