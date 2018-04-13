package com.example.admin.mvp_master.tools;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.admin.mvp_master.MainActivity;
import com.example.admin.mvp_master.R;

import java.lang.reflect.Field;
import java.util.List;


/**
 * Created by admin on 2018/4/3.
 */

public class BadgeUtils {


    //清除角标
    public static void removeBadge(Context context){
        setBadgeCountDevice(context,0);
    }

//    //获取ComponentName
//    private static ComponentName getComponentName(Context context) {
//        return context.getApplicationContext().getPackageManager()
//                .getLaunchIntentForPackage(context.getApplicationContext().getPackageName())
//                .getComponent();
//    }


    public static void setBadgeCountDevice(Context context,int badgeCount){
        String DeviveName=SystemUtil.getDeviceBrand();//手机厂商
        switch (DeviveName){
            case "vivo":
                Vivo(context,badgeCount);
                break;
            case "oppo":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "htc":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "samsung":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "meizu":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "zte":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "huawei":
                Huawei(context,badgeCount);
                break;
            case "miui":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "lenovo":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "gree":
                sendBadgeNumber(context,badgeCount+"");
                break;
            case "gionee":
                sendBadgeNumber(context,badgeCount+"");
                break;
        }

    }private static String getLauncherClassName(Context context) {
        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }




    //vivo
    public static void Vivo(Context context, int unReadCount){
        try {
            String launcherclassname = getLauncherClassName(context);
            if (launcherclassname != null) {
                Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent.putExtra("packageName", context.getPackageName());
                intent.putExtra("className", launcherclassname);
                intent.putExtra("notificationNum", unReadCount);
                context.sendBroadcast(intent);
            }
        }catch (Exception e){

        }
    }

    //华为设置角标
    public static void Huawei(Context context, int unReadCount){
        try{
            Bundle bunlde =new Bundle();
            bunlde.putString("package", "com.example.admin.mvp_master");
            bunlde.putString("class", "com.example.admin.mvp_master.MainActivity");
            bunlde.putInt("badgenumber",unReadCount);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/ba dge/"), "change_badge", null, bunlde);
        }catch(Exception e){
//            mIsSupportedBade = false;
        }
    }


    //其他设备角标
    private static void sendBadgeNumber(Context context, String unReadCount) {
        if (TextUtils.isEmpty(unReadCount)) {
            unReadCount = "0";
        } else {
            int numInt = Integer.valueOf(unReadCount);
            unReadCount = String.valueOf(Math.max(0, Math.min(numInt, 99)));
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            sendToXiaoMi(context,unReadCount);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            sendToSony(context,unReadCount);
        } else if (Build.MANUFACTURER.toLowerCase().contains("sony")) {
            sendToSamsumg(context,unReadCount);
        } else {
            Toast.makeText(context, "Not Support", Toast.LENGTH_LONG).show();
        }
    }

    private static void sendToXiaoMi(Context context,String number) {
        NotificationManager nm = (NotificationManager)context. getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = null;
        boolean isMiUIV6 = true;
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle("您有"+number+"未读消息");
            builder.setTicker("您有"+number+"未读消息");
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.mipmap.loading);
            builder.setDefaults(Notification.DEFAULT_LIGHTS);
            notification = builder.build();
            Class miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            field.set(miuiNotification, number);// 设置信息数
            field = notification.getClass().getField("extraNotification");
            field.setAccessible(true);
            field.set(notification, miuiNotification);
        }catch (Exception e) {
            e.printStackTrace();
            //miui 6之前的版本
            isMiUIV6 = false;
            Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            localIntent.putExtra("android.intent.extra.update_application_component_name",context.getPackageName() + "/"+ MainActivity.class );
            localIntent.putExtra("android.intent.extra.update_application_message_text",number);
            context.sendBroadcast(localIntent);
        }
        finally
        {
            if(notification!=null && isMiUIV6 )
            {
                //miui6以上版本需要使用通知发送
                nm.notify(101010, notification);
            }
        }

    }

    private static void sendToSony(Context context,String number) {
        boolean isShow = true;
        if ("0".equals(number)) {
            isShow = false;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE",isShow);//是否显示
        localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME",MainActivity.class );//启动页
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", number);//数字
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME",context.getPackageName());//包名
        context.sendBroadcast(localIntent);

        Toast.makeText(context, "Sony," + "isSendOk", Toast.LENGTH_LONG).show();
    }

    private static void sendToSamsumg(Context context,String number)
    {
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", number);//数字
        localIntent.putExtra("badge_count_package_name",context.getPackageName());//包名
        localIntent.putExtra("badge_count_class_name",MainActivity.class ); //启动页
        context.sendBroadcast(localIntent);
        Toast.makeText(context, "Samsumg," + "isSendOk", Toast.LENGTH_LONG).show();
    }


}
