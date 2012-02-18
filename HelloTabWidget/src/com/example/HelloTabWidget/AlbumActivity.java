package com.example.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AlbumActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView textview2 = new TextView(this);
        textview2.setText("Album Activity Text Input");
        setContentView(textview2);
    }
}