package com.example.admin.mvp_master.User.View.Atcualize;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.User.Presenter.Atcualize.LoginPresenter;
import com.example.admin.mvp_master.User.Presenter.Interface.ILoginPresenter;
import com.example.admin.mvp_master.User.View.Interface.ILoginView;
import com.example.admin.mvp_master.adapter.LoginRecyAdapter;
import com.example.admin.mvp_master.base.BasePermissionActivity;
import com.example.admin.mvp_master.base.BasePermissionSwipeActivity;
import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.other.RecyItemDecoration;
import com.example.admin.mvp_master.tools.DioalogUtil.LoadDioalog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2018/3/30.
 */

public class LoginActivity extends BasePermissionSwipeActivity implements ILoginView {

    private ILoginPresenter loginPresenter;
    private List<UserBean> userBeanList;
    private RecyclerView recyclerView;
    private LoginRecyAdapter mAdapter;
    private SmartRefreshLayout SmartRefreshLayout;
    private ClassicsHeader header;
    private ClassicsFooter footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wave_login_item_activity);
        loginPresenter=new LoginPresenter(this);
       loginPresenter.LoginToService("","");//发请求
        userBeanList=new ArrayList<>();
        SmartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.wave_swipe_refresh_layout);
        recyclerView= (RecyclerView) findViewById(R.id.recy_listview);
        header= (ClassicsHeader) findViewById(R.id.header);
        footer= (ClassicsFooter) findViewById(R.id.footer);
        // 设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置racy的方向
        recyclerView.setLayoutManager(layoutManager);
        userBeanList=new ArrayList<>();
        mAdapter = new LoginRecyAdapter(this,userBeanList);
        recyclerView.addItemDecoration(new RecyItemDecoration(Color.parseColor("#000000")));//设置item的线
        recyclerView.setAdapter(mAdapter);
       //设置 Header 为 贝塞尔雷达 样式
        SmartRefreshLayout.setRefreshHeader(new BezierRadarHeader(this));
//        //设置 Footer 为 球脉冲 样式
        SmartRefreshLayout.setRefreshFooter(footer);
        SmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loginPresenter.LoginToService("","");
            }
        });
        SmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loginPresenter.LoginToService("","");
            }
        });

    }



    private boolean aBoolean;
    @Override
    public void showProgress(boolean enable) {
        aBoolean=enable;
        if (aBoolean==false){
            LoadDioalog.dismiss(this);
            SmartRefreshLayout.finishRefresh();
            SmartRefreshLayout.finishLoadMore();
        }
    }
    LoadDioalog dioalog;
    @Override
    public void showLoading() {
        dioalog= new LoadDioalog(this);
        dioalog.showDialog(this).show();

    }


    @Override
    public void OnError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void OnSucceedList(List beanList) {
        this.userBeanList.clear();
        this.userBeanList.addAll(beanList);
        mAdapter.notifyDataSetChanged();
        Log.e("mvp",userBeanList.get(0).getMeans());
    }
}
