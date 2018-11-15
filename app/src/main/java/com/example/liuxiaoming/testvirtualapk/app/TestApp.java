package com.example.liuxiaoming.testvirtualapk.app;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

public class TestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
