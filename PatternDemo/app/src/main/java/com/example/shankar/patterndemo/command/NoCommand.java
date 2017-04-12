package com.example.shankar.patterndemo.command;

import android.util.Log;

/**
 * Created by shankar on 11/04/17.
 */

public class NoCommand implements Command {
	@Override
	public void execute() {
		Log.e("Command", "Not assigned");
	}
}
