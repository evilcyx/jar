package com.example.admin.mvp_master.base;

import android.os.Bundle;

import com.example.admin.mvp_master.tools.SwipeBackLayout.SwipeBackLayout;
import com.example.admin.mvp_master.tools.SwipeBackLayout.app.SwipeBackActivity;

/**
 * Created by Administrator on 2018/4/13.
 * 侧滑退出基类Activity
 *
 */

public class BaseActivity extends SwipeBackActivity {

    private SwipeBackLayout mSwipeBackLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        // 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        //mSwipeBackLayout.setEdgeSize(200);
    }

}
