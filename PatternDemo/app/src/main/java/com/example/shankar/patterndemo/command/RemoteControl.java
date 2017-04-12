package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 11/04/17.
 */

public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl(){
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for(int i=0; i<7; i++){
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommands(int slot, Command onCommand, Command offCommand){
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onWasPushed(int slot){
		onCommands[slot].execute();
	}

	public void offWasPushed(int slot){
		offCommands[slot].execute();
	}

	public String toString(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("remote_control\n");
		for(int i=0; i<onCommands.length; i++){
			stringBuffer.append("slot>"+i+" -> on>"+onCommands[i].getClass().getSimpleName()+", off>"+offCommands[i].getClass().getSimpleName()+"\n");
		}
		return stringBuffer.toString();
	}
}
