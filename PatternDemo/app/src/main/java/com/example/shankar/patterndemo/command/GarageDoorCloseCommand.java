package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 08/04/17.
 */

public class GarageDoorCloseCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorCloseCommand(GarageDoor garageDoor){
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.lightOff();
		garageDoor.down();
	}
}
