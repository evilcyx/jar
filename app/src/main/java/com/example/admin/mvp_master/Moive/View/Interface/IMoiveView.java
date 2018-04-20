package com.example.admin.mvp_master.Moive.View.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface IMoiveView extends RequestOnListener {

    void showProgress(boolean enable);//加载框

    void showLoading();
}
