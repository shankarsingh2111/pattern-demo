package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 08/04/17.
 */

public class LightOffCommand implements Command {

	Light light;

	public LightOffCommand(Light light){
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}
}
