package com.example.administrator.ndktest2;

/**
 * Created by Administrator on 2015/12/23.
 */
public class NdkJniUtil {
    static {
        System.loadLibrary("JniLib2");    //defaultConfig.ndk.moduleName
    }

    public native String getCLanguageString();

    public native int calc(int a, int b);
}