package com.example.hellolinearlayout;

import android.app.Activity;
import android.os.Bundle;

public class HelloLinearLayoutActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView - method load the layout file for the Activity
        // R.layout.main - refers to the folder with layout file .../res/layout/main.xml
        setContentView(R.layout.main);
    }
}