package com.example.araara;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

public class MyReceiver extends BroadcastReceiver {

    int[] AraAras = {R.raw.araara2,R.raw.araara3,R.raw.araara4,R.raw.araara5,R.raw.araara6};
    MediaPlayer mp;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Intent serviceIntent = new Intent(context, AraAraService.class);

        //context.startService(serviceIntent);

        //context.stopService(serviceIntent);
        mp = MediaPlayer.create(context, AraAras[new Random().nextInt(5)]);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.start();
       Log.d("Receiver", "Hello");
    }
}
