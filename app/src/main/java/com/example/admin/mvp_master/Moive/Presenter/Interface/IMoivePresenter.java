package com.example.admin.mvp_master.Moive.Presenter.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface IMoivePresenter extends RequestOnListener {

    void MoiveToSerive(int moiveId);

}
