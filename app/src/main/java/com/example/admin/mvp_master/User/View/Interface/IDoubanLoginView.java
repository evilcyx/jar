package com.example.admin.mvp_master.User.View.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

/**
 * Created by admin on 2018/3/30.
 */

public interface IDoubanLoginView extends RequestOnListener {

    void showProgress(boolean enable);//加载框

    void showLoading();




}
