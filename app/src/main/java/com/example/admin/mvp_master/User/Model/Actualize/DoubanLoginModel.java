package com.example.admin.mvp_master.User.Model.Actualize;

import com.example.admin.mvp_master.User.Model.Interface.IDoubanLoginModel;
import com.example.admin.mvp_master.User.Presenter.Interface.IDoubanLoginPresenter;

/**
 * Created by Administrator on 2018/4/16.
 */

public class DoubanLoginModel implements IDoubanLoginModel {

    private IDoubanLoginPresenter doubanLoginPresenter;

    public DoubanLoginModel(IDoubanLoginPresenter doubanLoginPresenter) {
        this.doubanLoginPresenter = doubanLoginPresenter;
    }

    @Override
    public void Login(String userNane, String userPwd) {
        if(userNane.equals("admin")&&userPwd.equals("123456")){
            doubanLoginPresenter.OnSucceedList("ok");
        }else {
            doubanLoginPresenter.OnSucceedList("onerr");
        }
    }
}
