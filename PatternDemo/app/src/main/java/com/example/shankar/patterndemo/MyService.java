package com.example.shankar.patterndemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

import com.example.shankar.patterndemo.mediaplayer.MediaButtonIntentReceiver;

public class MyService extends Service {
	public MyService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Log.e("MyService", "onStartCommand");

		((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(
				new ComponentName(
						getPackageName(),
						MediaButtonIntentReceiver.class.getName()));

		return START_NOT_STICKY;
	}


	@Override
	public void onTaskRemoved(Intent rootIntent) {
		super.onTaskRemoved(rootIntent);

//		Intent restartService = new Intent(getApplicationContext(), this.getClass());
//		restartService.setPackage(getPackageName());
//		PendingIntent restartServicePI = PendingIntent.getService(getApplicationContext(), 1, restartService, PendingIntent.FLAG_ONE_SHOT);
//		AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
//		alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 1000, restartServicePI);
//		stopSelf();
		Util.scheduleJob(this);
	}
}
