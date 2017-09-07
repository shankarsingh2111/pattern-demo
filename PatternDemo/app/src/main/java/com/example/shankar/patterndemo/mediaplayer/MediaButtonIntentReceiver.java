package com.example.shankar.patterndemo.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by shankar on 27/06/17.
 */

public class MediaButtonIntentReceiver extends BroadcastReceiver {

	public MediaButtonIntentReceiver() {
		super();
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String intentAction = intent.getAction();
		if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
			return;
		}
		KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
		if (event == null) {
			return;
		}
		int action = event.getAction();
		if (action == KeyEvent.ACTION_DOWN) {
			// do something
			Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
		}
	}
}
