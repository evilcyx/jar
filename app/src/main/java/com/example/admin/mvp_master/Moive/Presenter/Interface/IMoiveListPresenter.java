package com.example.admin.mvp_master.Moive.Presenter.Interface;

import com.example.admin.mvp_master.tools.network.RequestOnListener;

/**
 * Created by Administrator on 2018/4/16.
 */

public interface IMoiveListPresenter extends RequestOnListener {

    void MoiveListToSerive(String MoiveType);

}
