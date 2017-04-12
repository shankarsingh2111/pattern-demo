package com.example.shankar.patterndemo.command;

/**
 * Created by shankar on 12/04/17.
 */

public class MacroCommand implements Command {
	Command[] commands;

	public MacroCommand(Command[] commands){
		this.commands = commands;
	}

	@Override
	public void execute() {
		for(Command command : commands){
			command.execute();
		}
	}
}
