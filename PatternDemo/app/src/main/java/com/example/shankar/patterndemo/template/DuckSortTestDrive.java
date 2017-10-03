package com.example.shankar.patterndemo.template;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by shankar on 29/09/17.
 */

public class DuckSortTestDrive {

	public static void main(){

		Duck[] ducks = new Duck[]{
				new Duck(10),
				new Duck(8),
				new Duck(4),
				new Duck(9)
		};

		Log.w("Duck", "before sort");
		display(ducks);
		Arrays.sort(ducks);

		Log.w("Duck", "after sort");
		display(ducks);

	}

	private static void display(Duck[] ducks){
		for(Duck duck : ducks){
			Log.i("Duck", "Duck -> "+duck.weight);
		}
	}
}
