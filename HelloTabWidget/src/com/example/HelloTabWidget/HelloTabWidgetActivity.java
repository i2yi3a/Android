package com.example.HelloTabWidget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class HelloTabWidgetActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); //Resource object to get Drawable
        TabHost tabHost = getTabHost(); // The activity TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab
        
        /*
         * TabHost.TabSpec - stworzony, aby zdefiniowaæ properties ka¿dej zak³adki
         * newTabSpec(String) - metoda tworzenia nowych TabHost.TabSpec identyfikowanych przez podany string zak³adki
         * setIndicator(CharSequence,Drawable) - wywo³ana, aby ustawiæ text i ikon¹ zak³adce
         * setContent(Intent) - okreœlenie intencji, aby otworzyæ odpowiednie dzia³anie
         * addTab(TabHost.TabSpec) - wywo³anie dodania TabHost.TabSpec do TabHost
         * setCurrentTab(int) - okreœlenie defaultowo wyœwietlanej zak³adki okreœlonej przez indeks pozycji
         */
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ArtisticActivity.class);
        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("artists").setIndicator("Artists",
        		res.getDrawable(R.drawable.ic_tab_artists))
        		.setContent(intent);
        tabHost.addTab(spec);
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, AlbumActivity.class);
        spec = tabHost.newTabSpec("albums").setIndicator("Albums",
        		res.getDrawable(R.drawable.ic_tab_albums))
        		.setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, SongsActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Songs",
        		res.getDrawable(R.drawable.ic_tab_songs))
        		.setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(2);
    }
}