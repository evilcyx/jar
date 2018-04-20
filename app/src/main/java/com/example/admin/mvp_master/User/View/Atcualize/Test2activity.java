package com.example.admin.mvp_master.User.View.Atcualize;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.admin.mvp_master.MainActivity;
import com.example.admin.mvp_master.R;
import com.example.admin.mvp_master.adapter.test2.BitmapUtils;
import com.example.admin.mvp_master.adapter.test2.PhotoAdapter;
import com.example.admin.mvp_master.adapter.test2.ScalableCardHelper;

/**
 * 作者： 曹运霞 on 2018/4/20.
 * 邮箱：caoyunxia@n-i-nnovation.com
 * 逆创科技
 */

public class Test2activity extends Activity implements ScalableCardHelper.OnPageChangeListener{

    @DrawableRes
    private  final int[] PHTOTS = {
            R.mipmap.bg1,
            R.mipmap.bg1,
            R.mipmap.bg1,
            R.mipmap.bg1,
            R.mipmap.bg1
    };


    Bitmap[] BLURED_BITMAP = new Bitmap[PHTOTS.length];


    private ImageSwitcher backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);

        backgroundView = (ImageSwitcher) findViewById(R.id.image_switcher);
        Animation fadeIn = new AlphaAnimation(0.5f, 1);
        fadeIn.setDuration(500);
        backgroundView.setInAnimation(
                fadeIn
        );
        Animation fadeOut = new AlphaAnimation(0.5f, 0);
        fadeOut.setDuration(500);
        backgroundView.setOutAnimation(fadeOut);
        backgroundView.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Test2activity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_photo_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new PhotoAdapter(PHTOTS));
        ScalableCardHelper cardHelper = new ScalableCardHelper(this);
        cardHelper.attachToRecyclerView(recyclerView);


    }

    @Override
    public void onPageSelected(int position) {

        Bitmap bitmap = BLURED_BITMAP[position];
        if(bitmap == null){
            bitmap = BitmapFactory.decodeResource(getResources(), PHTOTS[position]);
            bitmap = BitmapUtils.blurBitmap(bitmap,25 , getApplicationContext());
            BLURED_BITMAP[position] = bitmap;
        }


        backgroundView.setImageDrawable(new BitmapDrawable(getResources(),bitmap));
    }

}
