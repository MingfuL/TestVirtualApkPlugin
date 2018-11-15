package com.example.liuxiaoming.testvirtualapk.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;

import java.io.File;

public class LoadApkUtils {

    public static void loadApk(Context context, String apkName){
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(context, "sdcard was NOT MOUNTED!", Toast.LENGTH_SHORT).show();
        }
        PluginManager pluginManager = PluginManager.getInstance(context);
        //从/sdcard/virtualApk/加载apk文件
        File apk = new File(Environment.getExternalStorageDirectory()+"/test/", apkName);
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
                Log.i(context.getClass().getSimpleName(), "Loaded plugin from apk: " + apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.i(context.getClass().getSimpleName(), "Loaded plugin from apk: " + apk+" not exit");
            try {
                File file = new File(context.getFilesDir(), "Test.apk");
                java.io.InputStream inputStream = context.getAssets().open("Test.apk", 2);
                java.io.FileOutputStream outputStream = new java.io.FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;

                while ((len = inputStream.read(buf)) > 0) {
                    outputStream.write(buf, 0, len);
                }

                outputStream.close();
                inputStream.close();
                pluginManager.loadPlugin(file);
                Log.i(context.getClass().getSimpleName(), "Loaded plugin from assets: " + file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
