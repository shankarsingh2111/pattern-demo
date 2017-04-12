package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 11/04/17.
 */

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo){
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(21);
	}
}
