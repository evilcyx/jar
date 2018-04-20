package com.example.admin.mvp_master.User.Presenter.Atcualize;

import com.example.admin.mvp_master.User.Model.Actualize.LoginModel;
import com.example.admin.mvp_master.User.Model.Interface.ILoginModel;
import com.example.admin.mvp_master.User.Presenter.Interface.ILoginPresenter;
import com.example.admin.mvp_master.User.View.Interface.ILoginView;
import com.example.admin.mvp_master.bean.UserBean;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel loginModel;
    private ILoginView loginView;

    public LoginPresenter( ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this);


    }

    @Override
    public void LoginToService(String userNane, String userPwd) {
        loginView.showLoading();
        loginView.showProgress(true);
        loginModel.Login(userNane,userPwd);
    }



    @Override
    public void OnError(Throwable e) {
        loginView.OnError(e);
        loginView.showProgress(false);
//        loginView.showLoading();
    }

    @Override
    public void OnSucceedList(List beanList) {
        loginView.OnSucceedList(beanList);
        loginView.showProgress(false);
//        loginView.showLoading();
    }

    @Override
    public void OnSucceedList(Object bean) {

    }


}
