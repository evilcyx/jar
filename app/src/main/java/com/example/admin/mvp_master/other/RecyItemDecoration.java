package com.example.admin.mvp_master.other;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by admin on 2018/4/3.
 */

public class RecyItemDecoration extends RecyclerView.ItemDecoration {

    private float mDividerHeight;
    private Paint mPaint;


    //实例化画笔
    public RecyItemDecoration(int color) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
    }

    //撑开 ItemView 上、下、左、右四个方向的空间
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //outRect 是一个全为 0 的 Rect。view 指 RecyclerView 中的 Item。parent 就是 RecyclerView 本身，state 就是一个状态
        //        //如果不是第一个，则设置top的值。
        if (parent.getChildAdapterPosition(view) != 0){
            //这里直接硬编码为1px
            outRect.top = 10;//间距
            mDividerHeight=1;//线的hight
        }
    }


    //绘制图形
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

        for ( int i = 0; i < childCount; i++ ) {
            View view = parent.getChildAt(i);

            int index = parent.getChildAdapterPosition(view);
            //第一个ItemView不需要绘制
            if ( index == 0 ) {
                continue;
            }
            float dividerTop = view.getTop() - mDividerHeight;
            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = view.getTop();
            float dividerRight = parent.getWidth() - parent.getPaddingRight();

            c.drawRect(dividerLeft,dividerTop,dividerRight,dividerBottom,mPaint);
        }

    }

    //绘制图形 角标 ItemDecoration 覆盖在 ItemView 内容之上
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
