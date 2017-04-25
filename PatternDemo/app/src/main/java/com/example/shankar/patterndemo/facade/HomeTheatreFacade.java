package com.example.shankar.patterndemo.facade;

import android.util.Log;

/**
 * Created by shankar on 19/04/17.
 */

public class HomeTheatreFacade {

	Amplifier amplifier;
	CDPlayer cdPlayer;
	DVDPlayer dvdPlayer;
	PopcornPopper popcornPopper;
	Projector projector;
	Screen screen;
	TheatreLights theatreLights;
	Tuner tuner;

	public HomeTheatreFacade(Amplifier amplifier, CDPlayer cdPlayer, DVDPlayer dvdPlayer, PopcornPopper popcornPopper,
							 Projector projector, Screen screen, TheatreLights theatreLights, Tuner tuner) {
		this.amplifier = amplifier;
		this.cdPlayer = cdPlayer;
		this.dvdPlayer = dvdPlayer;
		this.popcornPopper = popcornPopper;
		this.projector = projector;
		this.screen = screen;
		this.theatreLights = theatreLights;
		this.tuner = tuner;
	}

	public void watchMovie(String movie){
		Log.i("HomeTheatreFacade", "watchMovie");
		popcornPopper.on();
		popcornPopper.pop();
		theatreLights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setDVD(dvdPlayer);
		amplifier.setSurroundSound();
		amplifier.setVolume(5);
		dvdPlayer.on();
		dvdPlayer.play(movie);
	}

	public void endMovie(){
		Log.i("HomeTheatreFacade", "endMovie");
		popcornPopper.off();
		theatreLights.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvdPlayer.stop();
		dvdPlayer.eject();
		dvdPlayer.off();
	}

	public void listenToCD(){
		Log.i("HomeTheatreFacade", "listenToCD");
	}

	public void endCD(){
		Log.i("HomeTheatreFacade", "endCD");
	}

	public void listenToRadio(){
		Log.i("HomeTheatreFacade", "listenToRadio");
	}

	public void endRadio(){
		Log.i("HomeTheatreFacade", "endRadio");
	}

}
