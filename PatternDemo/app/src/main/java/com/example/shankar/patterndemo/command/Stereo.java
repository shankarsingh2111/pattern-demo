package com.example.shankar.patterndemo.command;

import android.util.Log;

/**
 * Created by shankar on 11/04/17.
 */

public class Stereo {

	int volume;

	public void on(){
		Log.i("Stereo", "on");
	}

	public void off(){
		Log.i("Stereo", "off");
	}

	public void setCD(){
		Log.i("Stereo", "setCd");
	}

	public void setDVD(){
		Log.i("Stereo", "setDVD");
	}

	public void setRadio(){
		Log.i("Stereo", "setRadio");
	}

	public void setVolume(int volume){
		this.volume = volume;
		Log.i("Stereo", "setVolume");
	}

}
