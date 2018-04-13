package com.example.admin.mvp_master;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.mvp_master.User.View.Atcualize.LoginActivity;
import com.example.admin.mvp_master.base.BasePermissionActivity;
import com.example.admin.mvp_master.tools.BadgeUtils;
import com.example.admin.mvp_master.tools.glideUtil.GlideCircleTransform;
import com.example.admin.mvp_master.tools.glideUtil.ImageCatchUtil;
import com.example.admin.mvp_master.tools.network.NetWorkReceiver;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static com.example.admin.mvp_master.tools.RequestTag.PERMISSION_CAMERA_TAG;
import static com.example.admin.mvp_master.tools.RequestTag.PERMISSION_PICTRUE_TAG;
import static com.example.admin.mvp_master.tools.RequestTag.USER_AVATAR_CAMERA_TAG;
import static com.example.admin.mvp_master.tools.RequestTag.USER_AVATAR_PICTRUE_TAG;

public class MainActivity extends BasePermissionActivity implements View.OnClickListener {

    private ArrayList<String> titles=new ArrayList<>();

    private XBanner xBanner;
    private ArrayList<String> images;

    private IntentFilter intentFilter;
    private NetWorkReceiver networkChangeReceiver;

    private PopupWindow popupWindow;

    private ImageView useravatar;

    private TextView btn_main;

    ImageCatchUtil catchUtil=new ImageCatchUtil();


    SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initState();
        setContentView(R.layout.activity_main);
        useravatar= (ImageView) findViewById(R.id.useravatar);
        btn_main= (TextView) findViewById(R.id.btn_main);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_cra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowUserAvatarPop(view);
            }
        });
        findViewById(R.id.clear_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catchUtil.clearImageDiskCache();
            }
        });
        xBanner = (XBanner) findViewById(R.id.banner);

        // 初始化XBanner中展示的数据
        images = new ArrayList<>();
        titles = new ArrayList<>();
        images.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
        titles.add("这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
        titles.add("这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
        titles.add("这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160906/1291473163104906.jpg");
        titles.add("这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片");


        // 为XBanner绑定数据
        xBanner.setData(images, titles);
// XBanner适配数据
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(MainActivity.this).load(images.get(position)).into((ImageView) view);
            }
        });

        // 设置XBanner的页面切换特效
        xBanner.setPageTransformer(Transformer.Accordion.Default);
// 设置XBanner页面切换的时间，即动画时长
        xBanner.setPageChangeDuration(1000);

        // XBanner中某一项的点击事件
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Toast.makeText(MainActivity.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetWorkReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        String chace=catchUtil.getCacheSize();
        btn_main.setText(chace+"");

    }

    private View UserAvatarView;
    private TextView useravatar_camera;
    private TextView useravatar_picture;
    private TextView cancel;
    private View alphaView;

    public void ShowUserAvatarPop(View view){
        if(popupWindow==null){
            DisplayMetrics metric = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metric);
            UserAvatarView= getLayoutInflater().inflate(R.layout.useravatar_layout,null);
            useravatar_camera=UserAvatarView.findViewById(R.id.useravatar_camera);
            useravatar_picture=UserAvatarView.findViewById(R.id.useravatar_picture);
            cancel=UserAvatarView.findViewById(R.id.cancel);
            alphaView=UserAvatarView.findViewById(R.id.alphaView);
            alphaView.setOnClickListener(this);
            useravatar_camera.setOnClickListener(this);
            useravatar_picture.setOnClickListener(this);
            cancel.setOnClickListener(this);
            popupWindow=new PopupWindow(UserAvatarView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,true);
        }
        // 设置允许在外点击消失
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.showAsDropDown(view, 0, 0);



        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    /**
     * 沉浸式状态栏
     */
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        BadgeUtils.setBadgeCountDevice(getApplication(),88);
        xBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        xBanner.stopAutoPlay();
    }

    /**
     * 权限成功回调函数
     *
     * @param requestCode
     */
    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        switch (requestCode) {
            case PERMISSION_CAMERA_TAG:
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, USER_AVATAR_CAMERA_TAG);
            break;
            case PERMISSION_PICTRUE_TAG:
                Intent ii = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(ii, USER_AVATAR_PICTRUE_TAG);
                break;
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.useravatar_camera:
                requestPermission(new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA_TAG);//先判断是否有拍照权限 再在权限回调中处理拍照
                break;
            case R.id.useravatar_picture:
                requestPermission(new String[]{Manifest.permission.CAMERA}, PERMISSION_PICTRUE_TAG);//先判断是否有拍照权限 再在权限回调中处理拍照
                break;
            case R.id.cancel:
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                break;
            case R.id.alphaView:
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
        }
    }
    private Bitmap bitmap ;//存放裁剪后的头像
    private String fileName;//头像名称
    private String picturePath;//头像路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case USER_AVATAR_CAMERA_TAG:
                Log.e("mvp","相机返回");
                Bitmap  photo = data.getParcelableExtra("data");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] bytes=baos.toByteArray();
                Glide.with(this).load(bytes).bitmapTransform(new GlideCircleTransform(this)).diskCacheStrategy(DiskCacheStrategy.ALL).into(useravatar);
                break;
            case USER_AVATAR_PICTRUE_TAG:
                Log.e("mvp","照片返回");
                Uri imageUri = data.getData();
                Log.e("TAG", imageUri.toString());
                Glide.with(this).load(imageUri).bitmapTransform(new GlideCircleTransform(this)).diskCacheStrategy(DiskCacheStrategy.ALL).into(useravatar);
                break;
        }
    }

    //获取图片的名称
    public String getBitmapName(String picPath){
        String bitmapName="";
        String[]  s = picPath.split("/");
        bitmapName = s[s.length-1];
        return bitmapName;
    }
}
