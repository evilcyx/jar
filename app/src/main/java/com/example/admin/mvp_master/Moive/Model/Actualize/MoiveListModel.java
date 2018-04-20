package com.example.admin.mvp_master.Moive.Model.Actualize;

import android.util.Log;

import com.example.admin.mvp_master.Moive.Model.Interface.IMoiveListModel;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoiveListPresenter;
import com.example.admin.mvp_master.bean.MoiveBeanList;
import com.example.admin.mvp_master.tools.network.ApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.admin.mvp_master.tools.network.ApiService.BASEDoubanUrl;

/**
 * Created by Administrator on 2018/4/16.
 */

public class MoiveListModel implements IMoiveListModel {

    private IMoiveListPresenter moiveListPresenter;

    public MoiveListModel(IMoiveListPresenter moiveListPresenter) {
        this.moiveListPresenter = moiveListPresenter;
    }


    @Override
    public void GetMoiveList(String MoiveType) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEDoubanUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        //调用方法得到一个Call
        Subscription subscription=apiService.getMoiveList(MoiveType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MoiveBeanList>() {
                    @Override
                    public void onCompleted() {
                        Log.e("mvp","完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        moiveListPresenter.OnError(e);
                    }

                    @Override
                    public void onNext(MoiveBeanList moiveBeanList) {
                        moiveListPresenter.OnSucceedList(moiveBeanList);
                    }
                });
    }
}
