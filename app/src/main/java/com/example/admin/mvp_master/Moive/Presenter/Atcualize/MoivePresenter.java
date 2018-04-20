package com.example.admin.mvp_master.Moive.Presenter.Atcualize;

import com.example.admin.mvp_master.Moive.Model.Actualize.MoiveModel;
import com.example.admin.mvp_master.Moive.Model.Interface.IMoiveModel;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoivePresenter;
import com.example.admin.mvp_master.Moive.View.Interface.IMoiveView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MoivePresenter implements IMoivePresenter {

    private IMoiveModel moiveModel;
    private IMoiveView moiveView;

    public MoivePresenter(IMoiveView moiveView) {
        this.moiveView = moiveView;
        this.moiveModel=new MoiveModel(this);
    }

    @Override
    public void MoiveToSerive(int moiveId) {
        moiveView.showLoading();
        moiveView.showProgress(true);
        moiveModel.GetMoive(moiveId);
    }

    @Override
    public void OnError(Throwable e) {
        moiveView.OnError(e);
        moiveView.showProgress(false);
    }

    @Override
    public void OnSucceedList(List beanList) {
        moiveView.OnSucceedList(beanList);
    }

    @Override
    public void OnSucceedList(Object bean) {
        moiveView.OnSucceedList(bean);
    }
}
