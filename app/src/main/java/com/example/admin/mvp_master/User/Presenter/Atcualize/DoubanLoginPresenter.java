package com.example.admin.mvp_master.User.Presenter.Atcualize;

import com.example.admin.mvp_master.User.Model.Actualize.DoubanLoginModel;
import com.example.admin.mvp_master.User.Model.Actualize.LoginModel;
import com.example.admin.mvp_master.User.Model.Interface.IDoubanLoginModel;
import com.example.admin.mvp_master.User.Model.Interface.ILoginModel;
import com.example.admin.mvp_master.User.Presenter.Interface.IDoubanLoginPresenter;
import com.example.admin.mvp_master.User.Presenter.Interface.ILoginPresenter;
import com.example.admin.mvp_master.User.View.Interface.IDoubanLoginView;
import com.example.admin.mvp_master.User.View.Interface.ILoginView;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class DoubanLoginPresenter implements IDoubanLoginPresenter {


    private IDoubanLoginModel doubanLoginModel;
    private IDoubanLoginView doubanLoginView;

    public DoubanLoginPresenter(IDoubanLoginView doubanLoginView) {
        this.doubanLoginView = doubanLoginView;
        this.doubanLoginModel=new DoubanLoginModel(this);
    }

    @Override
    public void LoginToService(String userNane, String userPwd) {
        doubanLoginView.showLoading();
        doubanLoginView.showProgress(true);
        doubanLoginModel.Login(userNane,userPwd);
    }

    @Override
    public void OnError(Throwable e) {

    }

    @Override
    public void OnSucceedList(List beanList) {

    }

    @Override
    public void OnSucceedList(Object bean) {
        doubanLoginView.OnSucceedList(bean);
        doubanLoginView.showProgress(false);
    }
}
