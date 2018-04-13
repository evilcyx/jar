package com.example.admin.mvp_master.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.bean.UserBean;
import com.example.admin.mvp_master.tools.glideUtil.GlideCircleTransform;

import java.util.ArrayList;

/**
 * Created by admin on 2018/4/1.
 */

public class LoginUserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<UserBean> userBeanArrayList;
    private LayoutInflater layoutInflater;
    


    public LoginUserAdapter(ArrayList<UserBean> userBeanArrayList, Context context) {
        this.userBeanArrayList = userBeanArrayList;
        this.context = context;
        this.	layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.login_item_activity,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.imguri);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(userBeanArrayList.get(position).getImguri()).bitmapTransform(new GlideCircleTransform(context)).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.imageView);
        return convertView;
    }




   private class  ViewHolder{
        ImageView imageView;
    }
}
