package com.example.liuxiaoming.testvirtualapk.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;
import com.example.liuxiaoming.testvirtualapk.R;
import com.example.liuxiaoming.testvirtualapk.utils.LoadApkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadApkUtils.loadApk(MainActivity.this, "test.apk");
                //包名
                final String pkg = "com.example.liuxiaoming.testvirtualapkplugin";
                LoadedPlugin loadedPlugin = PluginManager.getInstance(MainActivity.this).getLoadedPlugin(pkg);
                if (loadedPlugin == null) {
                    Toast.makeText(MainActivity.this, "plugin [com.example.liuxiaoming.testvirtualapkplugin] not loaded", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, "com.example.liuxiaoming.testvirtualapkplugin.PluginMainActivity");
                startActivity(intent);
            }
        });
    }
}
