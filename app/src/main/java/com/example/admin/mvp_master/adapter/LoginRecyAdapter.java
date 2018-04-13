package com.example.admin.mvp_master.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.glideUtil.GlideCircleTransform;

import java.util.List;

/**
 * Created by admin on 2018/4/2.
 */

public class LoginRecyAdapter extends RecyclerView.Adapter<LoginRecyAdapter.MyViewHolder> {

    private Context context;
    private List<UserBean> userBeanList;
    private LayoutInflater layoutInflater;

    public LoginRecyAdapter(Context context, List<UserBean> userBeanList) {
        this.context = context;
        this.userBeanList = userBeanList;
        this.layoutInflater = LayoutInflater.from(context);
    }


    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.login_item_activity,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.setIsRecyclable(false);
        if (mOnItemClickLitener != null)
        {
          //item的点击事件
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(userBeanList.get(position).getImguri()).bitmapTransform(new GlideCircleTransform(context)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return userBeanList.size();
    }


    @Override
    public int getItemViewType(int position) {

        return position;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imguri);

        }
    }




}
