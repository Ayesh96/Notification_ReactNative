package com.notificationapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Toast;

import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.soloader.SoLoader;

public class toastt extends ContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public toastt(Context context){
        super(context);
        this.reactContext = new ReactApplicationContext(context);
    }

    @ReactMethod
    public void showToast(){
        Toast.makeText(this.reactContext,"Showing toast by java native",Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return "toastt";
    }
}