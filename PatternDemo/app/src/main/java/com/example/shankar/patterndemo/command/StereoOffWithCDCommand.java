package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 11/04/17.
 */

public class StereoOffWithCDCommand implements Command {
	Stereo stereo;

	public StereoOffWithCDCommand(Stereo stereo){
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}
}
