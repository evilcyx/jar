package com.example.admin.mvp_master.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.mvp_master.R;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class GridMovieTypeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> mBean;


    public GridMovieTypeAdapter(Context context, List<String> mBean) {
        this.context = context;
        this.mBean = mBean;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBean.size();
    }

    @Override
    public Object getItem(int i) {
        return mBean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view!=null){
            viewHolder=new ViewHolder();
            view=inflater.inflate(R.layout.movie_search_type_layout,null);
            viewHolder.SeachType=view.findViewById(R.id.search_type);
           view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }

        return view;
    }

    private class ViewHolder{
        TextView SeachType;
    }
}
