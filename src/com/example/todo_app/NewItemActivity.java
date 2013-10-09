package com.example.todo_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewItemActivity extends Activity{

	private static final String TAG = "new-item-activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_item);

		final Button button = (Button) findViewById(R.id.new_item_ok);

         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 addItem();
             }
         });
	}
	
	void addItem() {
		final EditText textBox = (EditText) findViewById(R.id.new_item_text);
		Editable text = textBox.getText();
		Intent myIntent = new Intent(NewItemActivity.this, MainActivity.class);
		myIntent.putExtra("new_item_text", text.toString());
		this.startActivity(myIntent);
	}
	
}
