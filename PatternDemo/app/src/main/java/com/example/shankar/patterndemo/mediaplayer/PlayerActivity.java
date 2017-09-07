
package com.example.shankar.patterndemo.mediaplayer;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shankar.patterndemo.R;

public class PlayerActivity extends AppCompatActivity {

	private static final int STATE_PAUSED = 0;
	private static final int STATE_PLAYING = 1;

	private int mCurrentState;

	private MediaBrowserCompat mMediaBrowserCompat;
	private MediaControllerCompat mMediaControllerCompat;

	private Button mPlayPauseToggleButton;

	private MediaBrowserCompat.ConnectionCallback mMediaBrowserCompatConnectionCallback = new MediaBrowserCompat.ConnectionCallback() {

		@Override
		public void onConnected() {
			super.onConnected();
			try {
				mMediaControllerCompat = new MediaControllerCompat(PlayerActivity.this, mMediaBrowserCompat.getSessionToken());
				mMediaControllerCompat.registerCallback(mMediaControllerCompatCallback);
				setSupportMediaController(mMediaControllerCompat);
				getSupportMediaController().getTransportControls().playFromMediaId(String.valueOf(R.raw.warner_tautz_off_broadway), null);

			} catch( RemoteException e ) {

			}
		}
	};

	private MediaControllerCompat.Callback mMediaControllerCompatCallback = new MediaControllerCompat.Callback() {

		@Override
		public void onPlaybackStateChanged(PlaybackStateCompat state) {
			Log.e("mMediaControllerCompatCallback", "state>"+state);
			super.onPlaybackStateChanged(state);
			if( state == null ) {
				return;
			}

			switch(state.getState()) {
				case PlaybackStateCompat.STATE_PLAYING: {
					mCurrentState = STATE_PLAYING;
					break;
				}
				case PlaybackStateCompat.STATE_PAUSED: {
					mCurrentState = STATE_PAUSED;
					break;
				}
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		mPlayPauseToggleButton = (Button) findViewById(R.id.buttonPlayPause);

		mMediaBrowserCompat = new MediaBrowserCompat(this, new ComponentName(this, BackgroundAudioService.class),
				mMediaBrowserCompatConnectionCallback, getIntent().getExtras());

		mMediaBrowserCompat.connect();

		mPlayPauseToggleButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if( mCurrentState == STATE_PAUSED ) {
					getSupportMediaController().getTransportControls().play();
					mCurrentState = STATE_PLAYING;
				} else {
					if( getSupportMediaController().getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING ) {
						getSupportMediaController().getTransportControls().pause();
					}

					mCurrentState = STATE_PAUSED;
				}
			}
		});


//		mPlayPauseToggleButton.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				mPlayPauseToggleButton.performClick();
//			}
//		}, 1000);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if( getSupportMediaController().getPlaybackState().getState() == PlaybackStateCompat.STATE_PLAYING ) {
			getSupportMediaController().getTransportControls().pause();
		}

		mMediaBrowserCompat.disconnect();
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
			case KeyEvent.KEYCODE_MEDIA_PLAY:
				Toast.makeText(this, "presse", Toast.LENGTH_LONG).show();
				return true;
		}
		return false;

	}
}

