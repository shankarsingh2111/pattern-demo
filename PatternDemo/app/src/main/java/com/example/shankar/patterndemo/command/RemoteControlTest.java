package com.example.shankar.patterndemo.command;

import android.util.Log;

/**
 * Created by shankar on 08/04/17.
 */

public class RemoteControlTest {

	public static void main(String[] args){
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);

		simpleRemoteControl.setCommand(lightOnCommand);
		simpleRemoteControl.buttonWasPressed();

		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
		simpleRemoteControl.setCommand(garageDoorOpenCommand);
		simpleRemoteControl.buttonWasPressed();

		Stereo stereo = new Stereo();

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommands(0, lightOnCommand, new LightOffCommand(light));
		remoteControl.setCommands(1, garageDoorOpenCommand, new GarageDoorCloseCommand(garageDoor));
		remoteControl.setCommands(2, new StereoOnWithCDCommand(stereo), new StereoOffWithCDCommand(stereo));


		MacroCommand partyOn = new MacroCommand(new Command[]{new StereoOnWithCDCommand(stereo), lightOnCommand});
		MacroCommand partyOff = new MacroCommand(new Command[]{new StereoOffWithCDCommand(stereo), new LightOffCommand(light)});

		remoteControl.setCommands(3, partyOn, partyOff);



		Log.i("remoteControl=", ">"+remoteControl);

//		remoteControl.onWasPushed(1);
//		remoteControl.onWasPushed(2);
//		remoteControl.onWasPushed(0);
		remoteControl.onWasPushed(3);


//		remoteControl.offWasPushed(2);
//		remoteControl.offWasPushed(1);
//		remoteControl.offWasPushed(0);
		remoteControl.offWasPushed(3);



	}

}
