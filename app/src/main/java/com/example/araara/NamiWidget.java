package com.example.araara;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NamiWidget extends AppWidgetProvider {

    boolean isRunning = false;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.nami_widget);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        //PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        //views.setOnClickPendingIntent(R.id.button,pendingIntent);

        Intent serviceIntent = new Intent(context, AraAraService.class);
        Intent receiver = new Intent(context, MyReceiver.class);
        PendingIntent test = PendingIntent.getBroadcast(context, 0, receiver, 0);
        PendingIntent pending = PendingIntent.getBroadcast(context, 0 , serviceIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingServiceIntent = PendingIntent.getService(context,0,serviceIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.imageView2,test);


        Log.d("WidgetProvider","Hello");
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent){
        Log.d("onreceive", "Hi");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.nami_widget);
        Intent serviceIntent = new Intent(context, AraAraService.class);
        //context.stopService(serviceIntent);
        super.onReceive(context, intent);
    }
}


