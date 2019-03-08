package com.notificationapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Toast;
import android.app.NotificationManager;
import android.os.Build;
import android.app.NotificationChannel;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.soloader.SoLoader;

public class notifications extends ContextBaseJavaModule {
    private final ReactApplicationContext reactContext;
    NotificationCompat.Builder builder;

    public notifications(Context context){
        super(context);
        this.reactContext = new ReactApplicationContext(context);
    }

    @ReactMethod
    public void showToast(){
        Toast.makeText(reactContext,"Showing toast by java native",Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("HIGH", "HIGH", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = reactContext.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @ReactMethod
    public void createNotificationHigh(){
            builder = new NotificationCompat.Builder(reactContext, "HIGH")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("HIGH Priority Notification")
                .setContentText("Test Content")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(false)
                .setChannelId("HIGH")
                .setOngoing(true);



    }

    @ReactMethod
    public void renderNotification(){
        try{
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(reactContext);
        notificationManager.notify(100, builder.build());
        Toast.makeText(reactContext,"Rendered",Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(reactContext,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public String getName() {
        return "notifications";
    }
}