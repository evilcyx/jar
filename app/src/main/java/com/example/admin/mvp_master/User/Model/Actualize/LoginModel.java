package com.example.admin.mvp_master.User.Model.Actualize;

import android.util.Log;

import com.example.admin.mvp_master.User.Model.Interface.ILoginModel;
import com.example.admin.mvp_master.User.Presenter.Atcualize.LoginPresenter;
import com.example.admin.mvp_master.User.Presenter.Interface.ILoginPresenter;
import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.admin.mvp_master.tools.network.ApiService.BASE_URL;

/**
 * Created by admin on 2018/3/30.
 */

public class LoginModel implements ILoginModel {



    private ILoginPresenter loginPresenter;

    public LoginModel(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    List<UserBean> userBeanList=new ArrayList<>();
    @Override
    public void Login(String userNane, String userPwd) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //获取接口实例
        ApiService movieService = retrofit.create(ApiService.class);
        //调用方法得到一个Call
        Subscription subscription = movieService.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("mvp",",onCompleted()");
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        loginPresenter.OnError(e);
                    }

                    @Override
                    public void onNext(List<UserBean> userBeen) {
                        loginPresenter.OnSucceedList(userBeen);
                    }
                });
    }
}
