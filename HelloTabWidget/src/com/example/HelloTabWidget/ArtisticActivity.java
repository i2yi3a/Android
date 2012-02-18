package com.example.HelloTabWidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ArtisticActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView textview1 = new TextView(this);
        textview1.setText("Artistic Activity Text Input");
        setContentView(textview1);
    }
}
