package com.example.admin.mvp_master.tools.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_WIFI;

/**
 * Created by Administrator on 2018/4/9. 网络状态监听
 */

public class NetWorkReceiver extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            switch (networkInfo.getType()) {
                case TYPE_MOBILE:
                    Toast.makeText(context, "正在使用2G/3G/4G网络", Toast.LENGTH_SHORT).show();
                    break;
                case TYPE_WIFI:
                    Toast.makeText(context, "正在使用wifi上网", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        } else {
            Toast.makeText(context, "当前无网络连接", Toast.LENGTH_SHORT).show();
        }


    }


}
