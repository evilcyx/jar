package com.example.admin.mvp_master.Moive.Presenter.Atcualize;

import com.example.admin.mvp_master.Moive.Model.Actualize.MoiveListModel;
import com.example.admin.mvp_master.Moive.Model.Interface.IMoiveListModel;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoiveListPresenter;
import com.example.admin.mvp_master.Moive.View.Interface.IMoiveListView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/16.
 */

public class MoiveListPresenter implements IMoiveListPresenter {


    private IMoiveListModel moiveListModel;
    private IMoiveListView moiveListView;

    public MoiveListPresenter(IMoiveListView moiveListView) {
        this.moiveListView = moiveListView;
        this.moiveListModel = new MoiveListModel(this);
    }

    @Override
    public void MoiveListToSerive(String MoiveType) {
        moiveListView.showLoading();
        moiveListView.showProgress(true);
        moiveListModel.GetMoiveList(MoiveType);
    }

    @Override
    public void OnError(Throwable e) {
        moiveListView.OnError(e);
        moiveListView.showProgress(false);
    }

    @Override
    public void OnSucceedList(List beanList) {
        moiveListView.OnSucceedList(beanList);
        moiveListView.showProgress(false);
    }

    @Override
    public void OnSucceedList(Object bean) {
        moiveListView.OnSucceedList(bean);
        moiveListView.showProgress(false);
    }
}
