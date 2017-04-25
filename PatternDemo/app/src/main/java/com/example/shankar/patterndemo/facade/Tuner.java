package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class Tuner {

	Amplifier amplifier;

	public void on(){
		Log.i("Tuner", "on");
	}

	public void off(){
		Log.i("Tuner", "off");
	}

	public void setAM(){
		Log.i("Tuner", "setAM");
	}

	public void setFM(){
		Log.i("Tuner", "setFM");
	}

	public void setFrequency(){
		Log.i("Tuner", "setFrequency");
	}
}
