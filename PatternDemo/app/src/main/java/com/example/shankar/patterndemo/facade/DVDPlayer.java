package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class DVDPlayer {

	Amplifier amplifier;

	public void on(){
		Log.i("DVDPlayer", "on");
	}

	public void off(){
		Log.i("DVDPlayer", "off");
	}

	public void eject(){
		Log.i("DVDPlayer", "eject");
	}

	public void pause(){
		Log.i("DVDPlayer", "pause");
	}

	public void play(String movie){
		Log.i("DVDPlayer", "play>"+movie);
	}

	public void stop(){
		Log.i("DVDPlayer", "stop");
	}

	public void setSurroundAudio(){
		Log.i("DVDPlayer", "setSurroundAudio");
	}

	public void setTwoChannelAudio(){
		Log.i("DVDPlayer", "setTwoChannelAudio");
	}

}
