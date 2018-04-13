package com.example.admin.mvp_master.base;

import android.app.Application;

/**
 * Created by Administrator on 2018/4/12.
 */

public class BaseAppction extends Application {

    public static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
