package com.example.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SongsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview3 = new TextView(this);
        textview3.setText("Song Activity Text Input");
        setContentView(textview3);
    }
}