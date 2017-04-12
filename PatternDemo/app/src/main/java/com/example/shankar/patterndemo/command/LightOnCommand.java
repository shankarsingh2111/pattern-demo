package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 08/04/17.
 */

public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light){
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}
