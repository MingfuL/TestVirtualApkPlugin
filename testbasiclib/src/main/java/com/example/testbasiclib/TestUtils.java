package com.example.testbasiclib;

import android.content.Context;
import android.widget.Toast;

public class TestUtils {
    public static void TestToast(Context context){
        Toast.makeText(context, "TestUtils", Toast.LENGTH_LONG).show();
    }
}
