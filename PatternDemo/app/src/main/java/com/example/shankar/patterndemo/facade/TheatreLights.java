package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 18/04/17.
 */

public class TheatreLights {

	int lightIntensity;

	public void on(){
		Log.i("TheatreLights", "on");
	}

	public void off(){
		Log.i("TheatreLights", "off");
	}

	public void dim(int lightIntensity){
		this.lightIntensity = lightIntensity;
		Log.i("TheatreLights", "dim lightIntensity>"+lightIntensity);
	}

}
