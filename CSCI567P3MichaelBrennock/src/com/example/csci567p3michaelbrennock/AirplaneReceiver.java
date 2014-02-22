package com.example.csci567p3michaelbrennock;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.SoundPool;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class AirplaneReceiver extends BroadcastReceiver {

	private static final String TAG = "EventReceiver:AirplaneReceiver";
	private NotificationManager m_NotificationManager;
	private static final int NOTIFICATION_ID = 1;
	
	public AirplaneReceiver(){}
	
	@Override
	public void onReceive(Context c, Intent I) {
	
		if(I.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
			Log.d(TAG, "Airplane Changed");
			sendNotification(c, "Airplane Changed");
		}
	}
	
	public void sendNotification(Context c, String msg) {
		m_NotificationManager = (NotificationManager)c.getSystemService(Context.NOTIFICATION_SERVICE);
		
		PendingIntent contentIntent = PendingIntent.getActivity(c, 0, new Intent(c, MainActivity.class), 0);

		NotificationCompat.Builder m_Builder = 
				new NotificationCompat.Builder(c)
					.setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle(c.getString(R.string.airplane_alert))
					.setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
					.setContentText(msg);
		
		m_Builder.setContentIntent(contentIntent);
		m_NotificationManager.notify(NOTIFICATION_ID, m_Builder.build());
	}	
}
