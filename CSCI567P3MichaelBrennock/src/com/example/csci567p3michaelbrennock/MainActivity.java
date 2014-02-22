package com.example.csci567p3michaelbrennock;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.content.IntentFilter;
import android.content.Intent;

public class MainActivity extends Activity {

	AirplaneReceiver AR;
	IntentFilter IF;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		IF = new IntentFilter();
		
		IF.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
		registerReceiver(AR, IF);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
