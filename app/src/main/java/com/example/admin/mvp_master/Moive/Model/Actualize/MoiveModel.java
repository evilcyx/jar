package com.example.admin.mvp_master.Moive.Model.Actualize;

import android.util.Log;

import com.example.admin.mvp_master.Moive.Model.Interface.IMoiveModel;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoivePresenter;
import com.example.admin.mvp_master.bean.MoiveBean;
import com.example.admin.mvp_master.bean.MoiveBeanList;
import com.example.admin.mvp_master.tools.network.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.admin.mvp_master.tools.network.ApiService.BASEDoubanUrl;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MoiveModel implements IMoiveModel {

    private IMoivePresenter moivePresenter;

    public MoiveModel(IMoivePresenter moivePresenter) {
        this.moivePresenter = moivePresenter;
    }

    @Override
    public void GetMoive(int moiveId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEDoubanUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        //调用方法得到一个Call
        Subscription subscription=apiService.getMoive(moiveId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MoiveBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("mvp","完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        moivePresenter.OnError(e);
                    }

                    @Override
                    public void onNext(MoiveBean moiveBeanList) {
                        moivePresenter.OnSucceedList(moiveBeanList);
                    }
                });

    }
}
