package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class Projector {

	DVDPlayer dvdPlayer;

	public void on(){
		Log.i("Projector", "on");
	}

	public void off(){
		Log.i("Projector", "off");
	}

	public void tvMode(){
		Log.i("Projector", "tvMode");
	}

	public void wideScreenMode(){
		Log.i("Projector", "wideScreenMode");
	}

}
