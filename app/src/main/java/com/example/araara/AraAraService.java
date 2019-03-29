package com.example.araara;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

import static android.content.Intent.ACTION_SCREEN_ON;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class AraAraService extends Service {

private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() ==  ACTION_SCREEN_ON) //|| intent.getAction() == "android.provider.Telephony.SMS_RECEIVED")
            {
                Log.d("Action screen on!","Hello");
                playSound();
            }
        }
    };


    int[] AraAras = {R.raw.araara2,R.raw.araara3,R.raw.araara4,R.raw.araara5,R.raw.araara6};
    MediaPlayer mp;

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.araara.action.FOO";
    private static final String ACTION_BAZ = "com.example.araara.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.araara.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.araara.extra.PARAM2";

    public AraAraService() {

    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, AraAraService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, AraAraService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    public void onCreate(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_SCREEN_ON);
        //This requires <action android:name="android.provider.Telephony.SMS_RECEIVED" /> in the intent filter tag inside a receiver
        //filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver,filter);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void playSound(){

        mp = MediaPlayer.create(getApplicationContext(),AraAras[new Random().nextInt(4)]);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.start();
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy()
    {
        Log.d("onDestroy", "unregister receiver");
        unregisterReceiver(receiver);
    }
}
