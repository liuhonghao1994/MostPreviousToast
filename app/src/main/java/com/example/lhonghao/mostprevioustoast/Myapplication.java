package com.example.lhonghao.mostprevioustoast;

import android.app.Application;

import com.vondear.rxtools.RxUtils;

/**
 * Created by LiuHL on 2017/8/15.
 * qq:1173111672
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxUtils.init(this);
    }
}
