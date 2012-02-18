package com.example.datapicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DataPickerActivity extends Activity {
    /** Called when the activity is first created. */
    private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;
    
    // statyczny integer identyfikuj¹cy Dialog wyœwietlaj¹cy data pickera
    static final int DATE_DIALOG_ID = 0;
    
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // wyœwietlenie elementów na domyœlnym ekranie = data + przycisk "Change the date"
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);
        
        // dodanie obs³ugi przycisku PickDate
        mPickDate.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v) {
        		showDialog(DATE_DIALOG_ID);
        	}
        });
        
        //get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        //display the current date (this method is below)
        updateDisplay();
    }

    // uaktualnienie daty w polu TextView
	private void updateDisplay() {
		// klasa stworzona aby wypisywaæ datê na layout TextView
		mDateDisplay.setText(
				new StringBuilder()
					// Month is 0 based so add 1
					.append(mDay).append("-")	
					.append(mMonth + 1).append("-")
					.append(mYear).append(" "));
	}
	
	// the callback received when the user "sets" the date in the dialog
	/* 
	 * DatePickerDialog.OnDateSetListener nas³uchuje kiedy u¿ytkownik kliknie przycisk "Set" = wybierze datê
	 * najpierw wywo³ywana jest metoda onDateSet(), która jest zdefiniowana, ¿eby uaktualniæ wartoœci daty
	 * nastêpnie wywo³ywana jest updateDisplay() ¿eby odœwie¿yæ widok w TextView
	*/ 
	private DatePickerDialog.OnDateSetListener mDateSetListener =
			new DatePickerDialog.OnDateSetListener() {
		
				public void onDateSet(DatePicker view, int year,
						int monthOfYear, int dayOfMonth){
					mYear = year;
					mMonth = monthOfYear;
					mDay = dayOfMonth;
					updateDisplay();
				}
	};
	@Override
	protected Dialog onCreateDialog(int id){
		switch(id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this,
					mDateSetListener,
					mYear, mMonth, mDay);
		}
		return null;
		}
	}