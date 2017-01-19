package aqcxbom.testClassUnion;

import aqcxbom.CrackTools.LogUtils;

/**
 * Created by AqCxBoM on 2017/1/19.
 */

public class refTargetClass {
    private static void vfun(int n){
        LogUtils.DOLOG("refTargetClass->vfun runing!");
    }
    private static int ifun(int n, String str){
        LogUtils.DOLOG("refTargetClass->ifun runing!");
        return 1;
    }
    private static String strfun(String str, String str2){
        LogUtils.DOLOG("refTargetClass->strfun runing!");
        return str + str2;
    }
}
