package com.example.admin.mvp_master.User.View.Atcualize;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.adapter.test.CardRvAdapter;
import com.example.admin.mvp_master.adapter.test.CustomSnapHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 曹运霞 on 2018/4/20.
 * 邮箱：caoyunxia@n-i-nnovation.com
 * 逆创科技
 */

public class TestActivity extends Activity {

    private RecyclerView rv;
    private List<Integer> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        rv = (RecyclerView) findViewById(R.id.rv);
        mDataList = new ArrayList<>();
        mDataList.add(R.mipmap.bg1);
        mDataList.add(R.mipmap.bg1);
        mDataList.add(R.mipmap.bg1);
        mDataList.add(R.mipmap.bg1);
        mDataList.add(R.mipmap.bg1);
        mDataList.add(R.mipmap.bg1);
        // 设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置racy的方向
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(new CardRvAdapter(this, mDataList));
//        LinearSnapHelper mLinearSnapHelper = new LinearSnapHelper();
//        mLinearSnapHelper.attachToRecyclerView(rv);
        CustomSnapHelper mMySnapHelper = new CustomSnapHelper();
        mMySnapHelper.attachToRecyclerView(rv);
    }
}
