package com.martintecno.tp7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioMusica extends Service {
    private MediaPlayer MP;

    @Override
    public void onCreate() {
        super.onCreate();

        MP = MediaPlayer.create(this,R.raw.musicahd);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        MP.start();

        return  START_STICKY ;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        MP.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}