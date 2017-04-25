package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class Amplifier {

	Tuner tuner;
	CDPlayer cdPlayer;
	DVDPlayer dvdPlayer;
	int volume;

	public void on(){
		Log.i("Amplifier", "on");
	}

	public void off(){
		Log.i("Amplifier", "off");
	}

	public void setCD(CDPlayer cdPlayer){
		this.cdPlayer = cdPlayer;
		Log.i("Amplifier", "setCD>"+cdPlayer);
	}

	public void setDVD(DVDPlayer dvdPlayer){
		this.dvdPlayer = dvdPlayer;
		Log.i("Amplifier", "setDVD>"+dvdPlayer);
	}

	public void setStereoSound(){
		Log.i("Amplifier", "setStereoSound");
	}

	public void setSurroundSound(){
		Log.i("Amplifier", "setSurroundSound");
	}

	public void setTuner(Tuner tuner){
		this.tuner = tuner;
		Log.i("Amplifier", "setTuner");
	}

	public void setVolume(int volume){
		this.volume = volume;
		Log.i("Amplifier", "setVolume>"+volume);
	}

}
