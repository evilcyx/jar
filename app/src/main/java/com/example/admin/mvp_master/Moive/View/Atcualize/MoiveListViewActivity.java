package com.example.admin.mvp_master.Moive.View.Atcualize;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.admin.mvp_master.Moive.Presenter.Atcualize.MoiveListPresenter;
import com.example.admin.mvp_master.Moive.Presenter.Interface.IMoiveListPresenter;
import com.example.admin.mvp_master.Moive.View.Interface.IMoiveListView;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.adapter.GridMoiveListAdapter;
import com.example.admin.mvp_master.base.BasePermissionSwipeActivity;
import com.example.admin.mvp_master.bean.MoiveBeanList;
import com.example.admin.mvp_master.other.AppManager;
import com.makeramen.roundedimageview.RoundedImageView;
import com.stone.pile.libs.PileLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.mvp_master.tools.RequestTag.DOUBAN_Moive_TAG;

/**
 * Created by Administrator on 2018/4/17.
 */

public class MoiveListViewActivity extends BasePermissionSwipeActivity implements IMoiveListView,View.OnClickListener {

    private IMoiveListPresenter moiveListPresenter;
    private android.widget.EditText searchEdit;
    private android.widget.ImageView searchImg;
    private android.widget.RelativeLayout searchMoivelayout;
    private android.widget.GridView moiveGrid;
    private android.widget.RelativeLayout searchMoiveGrid;
    private GridMoiveListAdapter gridMoiveListAdapter;
    private MoiveBeanList moiveBeanList;
    private List<MoiveBeanList.SubjectsBean> moiveSubBeans;

//    PileLayout pileLayout;.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moive_list_layout);
        AppManager.getAppManager().addActivity(this);
        init();
        setOpation();
    }

    private void init(){
        moiveListPresenter=new MoiveListPresenter(this);
        this.searchMoiveGrid = (RelativeLayout) findViewById(R.id.searchMoive_Grid);
        this.moiveGrid = (GridView) findViewById(R.id.moive_Grid);
        this.searchMoivelayout = (RelativeLayout) findViewById(R.id.searchMoive_layout);
        this.searchImg = (ImageView) findViewById(R.id.search_Img);
        this.searchEdit = (EditText) findViewById(R.id.search_Edit);
//        this.pileLayout= (PileLayout) findViewById(R.id.pileLayout);
        moiveBeanList=new MoiveBeanList();
        moiveSubBeans=new ArrayList<>();
        moiveListPresenter.MoiveListToSerive("in_theaters");
        gridMoiveListAdapter=new GridMoiveListAdapter(this,moiveSubBeans);
        this.moiveGrid.setAdapter(gridMoiveListAdapter);
    }

    private void setOpation(){
        this.searchImg.setOnClickListener(this);
        moiveGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.e("test",moiveSubBeans.get(position).getId());
                Intent intent=new Intent(MoiveListViewActivity.this,MoiveViewActivity.class);
                intent.putExtra("moiveId",moiveSubBeans.get(position).getId());
                startActivityForResult(intent,DOUBAN_Moive_TAG);
            }
        });



    }

    @Override
    public void showProgress(boolean enable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void OnError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void OnSucceedList(List beanList) {
        Log.e("test","beanList"+beanList.toString());
    }

    @Override
    public void OnSucceedList(Object bean) {
        this.moiveSubBeans.clear();
        this.moiveBeanList= (MoiveBeanList) bean;
       List<MoiveBeanList.SubjectsBean> subjectsBean=this.moiveBeanList.getSubjects();
        this.moiveSubBeans.addAll(subjectsBean);
        gridMoiveListAdapter.notifyDataSetChanged();
//        pileLayout.setAdapter(new PileLayout.Adapter() {
//            @Override
//            public int getLayoutId() {
//                return R.layout.item_layout;
//            }
//
//            @Override
//            public void bindView(View view, int position) {
//                ViewHolder viewHolder = (ViewHolder) view.getTag();
//                if (viewHolder == null) {
//                    viewHolder = new ViewHolder();
//                    viewHolder.imageView = (RoundedImageView) view.findViewById(R.id.imageView);
//                    view.setTag(viewHolder);
//                }
//
//                Glide.with(MoiveListViewActivity.this).load(moiveSubBeans.get(position).getImages().getSmall()).into(viewHolder.imageView);
//            }
//
//            @Override
//            public int getItemCount() {
//                return moiveSubBeans.size();
//            }
//
//            @Override
//            public void displaying(int position) {
//
//            }
//
//            @Override
//            public void onItemClick(View view, int position) {
//                super.onItemClick(view, position);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_Img:
                if(searchEdit.getText().toString()!=null&&!searchEdit.getText().toString().equals("")){
                    moiveListPresenter.MoiveListToSerive(searchEdit.getText().toString());
                }
                break;
        }
    }

    class  ViewHolder{
        RoundedImageView imageView;
    }
}
