package com.ecample.hellogridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class HelloGridView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// creating a grid layout
		GridView gridview = (GridView) findViewById(R.id.gridview); // setting layout of view
		gridview.setAdapter(new ImageAdapter(this)); // setting custom adapter for displaying grid

		// creating an action after click on the grid items
		gridview.setOnItemClickListener(new OnItemClickListener() { // setting click listener
			// defining callback method to show a toast that display the index
			// position of selected item
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(HelloGridView.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	public class ImageAdapter extends BaseAdapter { // creating method that inherit from BaseAdapter
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
		}

		// constructor that count all items
		public int getCount() {
			return mThumbIds.length;
		}

		// should return actual object at the specified position in the adapter
		// here return null so this constructor is ignore
		public Object getItem(int position) {
			return null;
		}

		// should return the row id of the item
		// here return zero so is ignore
		public long getItemId(int position) {
			return 0;
		}

		// method - create a new ImageView for each item referenced (added to)
		// by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				// if it's not recycled, initialize some attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(85, 85)); // set height and width for the View
																				// (dimension) in grid view all images
																				// are resized to fit in the dimension
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // declares
																			// tha
																			// images
																			// should
																			// be
																			// cropped
																			// toward
																			// the
																			// center
				imageView.setPadding(8, 8, 8, 8); // defines the padding for all
													// sides
			} else {
				imageView = (ImageView) convertView; // ...
			}

			// the "position" integer passed into the method is used to select
			// an image from mThumbIds array
			// which is set as the image resource for the ImageView
			imageView.setImageResource(mThumbIds[position]);
			return imageView;
		}

		// references to our images
		private Integer[] mThumbIds = {
				R.drawable.sample_2, R.drawable.sample_3, 
				R.drawable.sample_4, R.drawable.sample_5, 
				R.drawable.sample_6, R.drawable.sample_7,
				R.drawable.sample_0, R.drawable.sample_1, 
				R.drawable.sample_2, R.drawable.sample_3, 
				R.drawable.sample_4, R.drawable.sample_5,
				R.drawable.sample_6, R.drawable.sample_7, 
				R.drawable.sample_0, R.drawable.sample_1, 
				R.drawable.sample_2, R.drawable.sample_3,
				R.drawable.sample_4, R.drawable.sample_5, 
				R.drawable.sample_6, R.drawable.sample_7 
				};
	}
}