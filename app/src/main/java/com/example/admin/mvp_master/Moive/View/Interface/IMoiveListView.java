package com.example.admin.mvp_master.Moive.View.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

/**
 * Created by Administrator on 2018/4/17.
 */

public interface IMoiveListView extends RequestOnListener {

    void showProgress(boolean enable);//加载框

    void showLoading();

}
