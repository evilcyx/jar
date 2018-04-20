package com.example.admin.mvp_master.Moive.View.Atcualize;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.mvp_master.Moive.Presenter.Atcualize.MoivePresenter;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoivePresenter;
import com.example.admin.mvp_master.Moive.View.Interface.IMoiveView;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.base.BasePermissionSwipeActivity;
import com.example.admin.mvp_master.bean.MoiveBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MoiveViewActivity extends BasePermissionSwipeActivity implements IMoiveView {


    private android.widget.TextView moivetitle;
    private android.widget.ImageView moiveimage;
    private android.widget.TextView moivedirector;
    private android.widget.TextView moiveprotagonist;
    private android.widget.TextView moivetype;
    private android.widget.LinearLayout moivebase;
    private android.widget.TextView moivesynopsis;
    private android.widget.TextView moiveintroduce;
    private android.widget.LinearLayout moivecontext;
    private TextView moiveyear;
    private int MoiveId=-1;
    private IMoivePresenter moivePresenter;
    private MoiveBean moiveBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moive_details_layout);
       init();
       setOpation();
    }




    private void init() {
        this.moivecontext = (LinearLayout) findViewById(R.id.moive_context);
        this.moiveintroduce = (TextView) findViewById(R.id.moive_introduce);
        this.moivesynopsis = (TextView) findViewById(R.id.moive_synopsis);
        this.moivebase = (LinearLayout) findViewById(R.id.moive_base);
        this.moivetype = (TextView) findViewById(R.id.moive_type);
        this.moiveprotagonist = (TextView) findViewById(R.id.moive_protagonist);
        this.moivedirector = (TextView) findViewById(R.id.moive_director);
        this.moiveimage = (ImageView) findViewById(R.id.moive_image);
        this.moivetitle = (TextView) findViewById(R.id.moive_title);
        this.moiveyear= (TextView) findViewById(R.id.moive_year);
        moivePresenter=new MoivePresenter(this);
    }



    private void setOpation() {
        Intent intent=getIntent();
        if(intent!=null){
            String MoiveStr=intent.getStringExtra("moiveId");
            MoiveId=Integer.parseInt(MoiveStr);
        }
        moivePresenter.MoiveToSerive(MoiveId);

    }

    private void initData() {
        Glide.with(this).load(moiveBean.getImages().getSmall()).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.moiveimage);
        this.moivetitle.setText(moiveBean.getTitle());
        this.moivedirector.setText(moiveBean.getDirectors().get(0).getName());
        String castStr="";
        for (MoiveBean.CastsBean castsBean:moiveBean.getCasts()){
            castStr=castsBean.getName()+"/"+castStr;
        }
        String genresStr="";
        for (String genresBean:moiveBean.getGenres()){
            genresStr=genresBean.toString()+"/"+genresStr;
        }
        this.moiveprotagonist.setText(castStr);
        this.moivetype.setText(genresStr);
        this.moivesynopsis.setText(moiveBean.getTitle()+"的剧情简介...");
        this.moiveintroduce.setText(moiveBean.getSummary());
        this.moiveyear.setText("上映日期："+moiveBean.getYear());
    }

    @Override
    public void showProgress(boolean enable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void OnError(Throwable e) {

    }

    @Override
    public void OnSucceedList(List beanList) {

    }

    @Override
    public void OnSucceedList(Object bean) {
        moiveBean= (MoiveBean) bean;
        initData();
        Log.e("test",bean.toString());
    }
}
