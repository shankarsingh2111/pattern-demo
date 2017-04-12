package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 08/04/17.
 */

public class GarageDoorOpenCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor){
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();
		garageDoor.lightOn();
	}
}
