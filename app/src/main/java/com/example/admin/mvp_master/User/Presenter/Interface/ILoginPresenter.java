package com.example.admin.mvp_master.User.Presenter.Interface;

import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.network.RequestOnListener;

import java.util.List;

import static android.R.id.list;

/**
 * Created by admin on 2018/3/30.
 */

public interface ILoginPresenter extends RequestOnListener{

    void LoginToService(String userNane, String userPwd);

}
