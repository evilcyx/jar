package com.example.admin.mvp_master.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.mvp_master.Moive.View.Atcualize.MoiveViewActivity;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.bean.MoiveBeanList;
import com.example.admin.mvp_master.tools.glideUtil.GlideCircleTransform;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public class GridMoiveListAdapter extends BaseAdapter {


    private Context context;
    private List<MoiveBeanList.SubjectsBean> beanLists;
    private LayoutInflater inflater;

    public GridMoiveListAdapter(Context context, List<MoiveBeanList.SubjectsBean> beanLists) {
        this.context = context;
        this.beanLists = beanLists;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beanLists.size();
    }

    @Override
    public Object getItem(int i) {
        return beanLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder = new ViewHolder();
            view=inflater.inflate(R.layout.moive_item_layout,null);
           viewHolder.moive_image=view.findViewById(R.id.moive_image);
           viewHolder.moive_title=view.findViewById(R.id.moive_title);
           viewHolder.moive_star=view.findViewById(R.id.moive_star);
           viewHolder.moive_score=view.findViewById(R.id.moive_score);
           view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }

        getBean(i,beanLists,viewHolder);
        return view;
    }


    private void getBean(int position,List<MoiveBeanList.SubjectsBean> beanLists,ViewHolder viewHolder){
        Glide.with(context).load(beanLists.get(position).getImages().getSmall()).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.moive_image);
        viewHolder.moive_title.setText(beanLists.get(position).getTitle());
        viewHolder.moive_star.setRating((float) (beanLists.get(position).getRating().getAverage()/2));
        viewHolder.moive_score.setText(beanLists.get(position).getRating().getAverage()+"");
    }

    private class ViewHolder{
        private ImageView moive_image;
        private TextView moive_title;
        private RatingBar moive_star;
        private TextView moive_score;

    }
}
