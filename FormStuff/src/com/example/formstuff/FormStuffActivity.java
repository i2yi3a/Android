package com.example.formstuff;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormStuffActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		// Wykonanie akcji klikniêcia
        		Toast.makeText(FormStuffActivity.this, "Beep Bop", Toast.LENGTH_SHORT).show();
        	}
        });
        // dodanie do layoutu elemenu EditText z pliku main.xml
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        //  implementacja nas³uchiwania
        edittext.setOnKeyListener(new OnKeyListener() {
        	public boolean onKey(View v, int keyCode, KeyEvent event) {
        		// if the event is a key-down event on the "enter" button
        		// gdy wciœniêty przycisk w dó³ (czyli pole tekstowe jest aktywne) i przyciœnie siê Enter
        		// wyœwietlone zostanie s³owo (metoda Toast) wpisane w pole tekstowe 
        		if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
        				(keyCode == KeyEvent.KEYCODE_ENTER)) {
        			// Perform action on key press
        			Toast.makeText(FormStuffActivity.this, edittext.getText(), Toast.LENGTH_SHORT).show();
        			return true;
        		}
        		return false;
        	}
        });
        
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        // deklaracja nas³uchiwania akcji i wykonywania odpowiednich "reakcji"
        checkbox.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		//Perform action on clicks, depending on whether 
        		// sprawdzenie warunku, jeœli po klikniêciu checkbox jest zaznaczony to wyœwietli "Selected"
        		// jeœli po klikniêciu checkbox jest odznaczony to "Not selected"
        		if (((CheckBox) v).isChecked()) {
        			Toast.makeText(FormStuffActivity.this, "Selected", Toast.LENGTH_SHORT).show();
        		}
        		else {
        			Toast.makeText(FormStuffActivity.this, "Not selected", Toast.LENGTH_SHORT).show();
        		}
        	}
        });
        
        final RadioButton radio_red = (RadioButton) findViewById(R.id.radio_red);
        final RadioButton radio_blue = (RadioButton) findViewById(R.id.radio_blue);
        radio_red.setOnClickListener(radio_listener);
        radio_blue.setOnClickListener(radio_listener);
        
        
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){
        	public void onRatingChanged(RatingBar ratingbar, float rating, boolean fromUser){
        		Toast.makeText(FormStuffActivity.this,"New Rating: " + rating, Toast.LENGTH_SHORT).show();
        	}
        });
        
        final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
        togglebutton.setOnClickListener(new OnClickListener(){
        	public void onClick(View c){
        		if (togglebutton.isChecked()){
        			Toast.makeText(FormStuffActivity.this, "Checked", Toast.LENGTH_SHORT).show();
        			}
        		else
        			Toast.makeText(FormStuffActivity.this, "Not checked", Toast.LENGTH_SHORT).show();
        		}
        });
    }
    
    private OnClickListener radio_listener = new OnClickListener() {
    	public void onClick(View v){
    		// Perform action on clicks
    		RadioButton rb = (RadioButton) v;
    		Toast.makeText(FormStuffActivity.this,rb.getText(),Toast.LENGTH_SHORT).show();
    	}
    };
}