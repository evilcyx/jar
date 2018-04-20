package com.example.admin.mvp_master.User.Presenter.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

/**
 * Created by admin on 2018/3/30.
 */

public interface IDoubanLoginPresenter extends RequestOnListener{

    void LoginToService(String userNane, String userPwd);

}
