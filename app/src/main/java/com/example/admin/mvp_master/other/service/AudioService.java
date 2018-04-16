package com.example.admin.mvp_master.other.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.admin.mvp_master.R;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/16.
 */


public class AudioService extends Service implements
        MediaPlayer.OnCompletionListener {
    // 实例化MediaPlayer对象
    MediaPlayer player;
    private final IBinder binder = new AudioBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void onCreate() {
        super.onCreate();
        // 从raw文件夹中获取一个应用自带的mp3文件
        player = MediaPlayer.create(this, R.raw.hxl);
        player.setOnCompletionListener(this);
        player.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (!player.isPlaying()) {
            new MusicPlayThread().start();
        }
        else player.isPlaying();
        return START_STICKY;
    }


    /**
     * 当Audio播放完的时候触发该动作
     */
    public void onCompletion(MediaPlayer mp) {
        stopSelf();// 结束了，则结束Service

    }

    public void onDestroy() {
        super.onDestroy();
        if (player.isPlaying()) {
            player.stop();
        }
        player.release();
    }

    // 为了和Activity交互，我们需要定义一个Binder对象
    public class AudioBinder extends Binder {
        // 返回Service对象
        public AudioService getService() {
            return AudioService.this;
        }
    }

    private class MusicPlayThread extends Thread {
        public void run() {
            if (!player.isPlaying()) {
                player.start();
            }
        }
    }

}