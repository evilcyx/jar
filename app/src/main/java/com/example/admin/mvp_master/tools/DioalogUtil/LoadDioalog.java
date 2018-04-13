package com.example.admin.mvp_master.tools.DioalogUtil;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.admin.mvp_master.R;

/**
 * Created by admin on 2018/4/3.
 */

public class LoadDioalog extends Dialog {


    private Context context;
    private static LoadDioalog dialog;
    private ImageView ivProgress;


    public LoadDioalog(Context context) {
        super(context);
        this.context = context;
    }

    public LoadDioalog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;

    }
    //显示dialog的方法
    public static LoadDioalog showDialog(Context context){
        dialog = new LoadDioalog(context, R.style.loadDioalog);//dialog样式
        dialog.setContentView(R.layout.load_dioalog_layout);//dialog布局文件
        dialog.setCanceledOnTouchOutside(false);//点击外部不允许关闭dialog
        return dialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && dialog != null){
            ivProgress = (ImageView) dialog.findViewById(R.id.ivProgress);
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.load_dioalog);
            ivProgress.startAnimation(animation);
        }
    }

    /**
     * dismiss the dialog
     */
    public static void dismiss(Context context) {
        try {
            if (context instanceof Activity) {
                if (((Activity) context).isFinishing()) {
                    dialog = null;
                    return;
                }
            }
            if (dialog != null && dialog.isShowing()) {
                Context loadContext = dialog.getContext();
                if (loadContext != null && loadContext instanceof Activity) {
                    if (((Activity) loadContext).isFinishing()) {
                        dialog = null;
                        return;
                    }
                }
                dialog.dismiss();
                dialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dialog = null;
        }
    }

}
