package com.example.csci567p3michaelbrennock;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.Intent;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		IntentFilter intentFilter = new IntentFilter("android.intent.action.SERVICE_STATE");
		BroadcastReceiver receiver = new BroadcastReceiver()
		{

			@Override
			public void onReceive(Context context, Intent intent) {
				Log.d("AirplaneMode", "Service state changed");
				Toast toast = Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT);
				toast.show();
				
			}
			
		};
		
		this.getApplicationContext().registerReceiver(receiver, intentFilter);
	}
	
}
