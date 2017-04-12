package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 08/04/17.
 */

public class SimpleRemoteControl {

	Command slot;

	public SimpleRemoteControl(){

	}

	public void setCommand(Command command){
		this.slot = command;
	}

	public void buttonWasPressed(){
		slot.execute();
	}

}
