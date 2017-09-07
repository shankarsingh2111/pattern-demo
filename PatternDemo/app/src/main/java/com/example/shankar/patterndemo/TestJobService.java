package com.example.shankar.patterndemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by shankar on 07/09/17.
 */

public class TestJobService extends JobService {
	private static final String TAG = "SyncService";

	@Override
	public boolean onStartJob(JobParameters params) {
		Intent service = new Intent(getApplicationContext(), LocalWordService.class);
		getApplicationContext().startService(service);
		Util.scheduleJob(getApplicationContext()); // reschedule the job
		Log.e("TestJobService", "onStartJob");
		return true;
	}

	@Override
	public boolean onStopJob(JobParameters params) {
		return true;
	}

}