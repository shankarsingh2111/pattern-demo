package com.example.shankar.patterndemo.adapter;

import android.util.Log;

/**
 * Created by shankar on 17/04/17.
 */

public class WildTurkey implements Turkey {
	@Override
	public void gobble() {
		Log.i("WildTurkey", "gobble");
	}

	@Override
	public void fly() {
		Log.i("WildTurkey", "fly");
	}
}
