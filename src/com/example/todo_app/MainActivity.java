package com.example.todo_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {

	private static final String TAG = "main-activity";
	
    // Array list of strings.
	// TODO Change this to TodoItem objects.
    ArrayList<String> listItems = new ArrayList<String>();

    // Adapter that will handle the list view data.
    ArrayAdapter<String> adapter;
	

	String[] values = new String[] { "Drop off laundry", "Buy meat"};
	
	@Override
	protected void onResume() {
		Log.v(TAG, "onResume()");
		super.onResume();
		// If the intent that woke us up has extras
		if (getIntent().getExtras() != null) {
	        String itemText = (String) getIntent().getExtras().get("new_item_text");
	        if (itemText != null) {
	        	listItems.add(itemText);
	            Log.v(TAG, "List size: " + listItems.size());
	        	adapter.notifyDataSetChanged();
	        }
		}
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		Log.v(TAG, "onNewIntent()");
	    super.onNewIntent(intent);
	    // getIntent() should always return the most recent
	    setIntent(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for (int i = 0; i < values.length; i++) {
			listItems.add(values[i]);
		}
		
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
        Log.v(TAG, "List size: " + listItems.size());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_new:
	        	createNewItem();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	void openSettings() {
		Log.v(TAG, "Open Settings button pressed.");
	}
	
	void createNewItem() {
		Log.v(TAG, "New Item button pressed.");
		
		Intent myIntent = new Intent(MainActivity.this, NewItemActivity.class);
		this.startActivity(myIntent);
		

	}
	
	
	
}