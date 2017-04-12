package com.example.shankar.patterndemo.command;

import android.util.Log;

/**
 * Created by shankar on 08/04/17.
 */

public class GarageDoor {

	public void up(){
		Log.i("GarageDoor", "up");
	}

	public void down(){
		Log.i("GarageDoor", "down");
	}

	public void stop(){
		Log.i("GarageDoor", "stop");
	}

	public void lightOn(){
		Log.i("GarageDoor", "lightOn");
	}

	public void lightOff(){
		Log.i("GarageDoor", "lightOff");
	}

}
