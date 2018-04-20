package com.example.admin.mvp_master.User.View.Atcualize;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.mvp_master.Moive.View.Atcualize.MoiveListViewActivity;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.User.Presenter.Atcualize.DoubanLoginPresenter;
import com.example.admin.mvp_master.User.Presenter.Interface.IDoubanLoginPresenter;
import com.example.admin.mvp_master.User.View.Interface.IDoubanLoginView;
import com.example.admin.mvp_master.base.BasePermissionSwipeActivity;
import com.example.admin.mvp_master.other.AppManager;
import com.example.admin.mvp_master.tools.toast.ToastUtil;

import java.util.List;

import static com.example.admin.mvp_master.tools.RequestTag.DOUBAN_MoiveList_TAG;

/**
 * Created by Administrator on 2018/4/16.
 */

public class DoubanLoginActivity extends BasePermissionSwipeActivity implements IDoubanLoginView,View.OnClickListener {

    private EditText userName;
    private EditText userPwd;
    private Button userLoginBtn;
    private Button userCancel;
    private IDoubanLoginPresenter doubanLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.douban_login_layout);
        AppManager.getAppManager().addActivity(this);
        init();
        setOpation();
    }

    private void init(){
        doubanLoginPresenter=new DoubanLoginPresenter(this);
        userName= (EditText) findViewById(R.id.dou_username);
        userPwd= (EditText) findViewById(R.id.dou_userpwd);
        userLoginBtn= (Button) findViewById(R.id.userLoginBtn);
        userCancel= (Button) findViewById(R.id.userCancel);
    }

    private void setOpation(){
        userLoginBtn.setOnClickListener(this);
        userCancel.setOnClickListener(this);
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
        if(bean.toString().equals("ok")){
            ToastUtil.showToast(this,"登录成功");
            Intent intent=new Intent(this, MoiveListViewActivity.class);
            startActivityForResult(intent,DOUBAN_MoiveList_TAG);
            AppManager.getAppManager().finishActivity(this);
        }else{
            ToastUtil.showToast(this,"用户名或密码错误");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userLoginBtn:
                if(!userName.getText().toString().equals("")&&!userPwd.getText().toString().equals("")){
                    doubanLoginPresenter.LoginToService(userName.getText().toString(),userPwd.getText().toString());
                }else{
                    ToastUtil.showToast(this,"用户名或密码不能为空");
                }
                break;
            case R.id.userCancel:
                finish();
                break;
        }
    }
}
