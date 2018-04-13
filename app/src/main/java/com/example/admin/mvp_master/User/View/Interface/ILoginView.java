package com.example.admin.mvp_master.User.View.Interface;

import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.network.RequestOnListener;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public interface ILoginView extends RequestOnListener {

    void showProgress(boolean enable);//加载框

    void showLoading();




}
