package com.example.admin.mvp_master.tools.network;

import android.content.DialogInterface;

import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.OnBooleanListener;

import java.util.List;

/**
 * Created by admin on 2018/4/4.
 * 请求公共接口
 */

public interface RequestOnListener<T>{

    void OnError(Throwable e);

    void OnSucceedList(List<T> beanList);//泛型集合

    void OnSucceedList(T bean);//泛型对象


}
