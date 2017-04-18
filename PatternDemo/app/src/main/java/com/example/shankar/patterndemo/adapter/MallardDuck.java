package com.example.shankar.patterndemo.adapter;

import android.util.Log;

/**
 * Created by shankar on 17/04/17.
 */

public class MallardDuck implements Duck {
	@Override
	public void quack() {
		Log.i("MallardDuck", "quack");
	}

	@Override
	public void fly() {
		Log.i("MallardDuck", "fly");
	}
}
