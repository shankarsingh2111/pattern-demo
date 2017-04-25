package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class CDPlayer {

	Amplifier amplifier;

	public void on(){
		Log.i("CDPlayer", "on");
	}

	public void off(){
		Log.i("CDPlayer", "off");
	}

	public void eject(){
		Log.i("CDPlayer", "eject");
	}

	public void pause(){
		Log.i("CDPlayer", "pause");
	}

	public void play(){
		Log.i("CDPlayer", "play");
	}

	public void stop(){
		Log.i("CDPlayer", "stop");
	}

}
