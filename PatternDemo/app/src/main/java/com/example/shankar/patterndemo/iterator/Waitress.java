package com.example.shankar.patterndemo.iterator;

import android.util.Log;

import java.util.Iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu(){
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();

		Log.i("Waitress", "Breakfast menu");
		printMenu(pancakeIterator);
		Log.i("Waitress", "Diner menu");
		printMenu(dinerIterator);
	}

	private void printMenu(Iterator iterator){
		while (iterator.hasNext()){
			MenuItem menuItem = (MenuItem) iterator.next();
			Log.i("Waitress", menuItem.getName()+" - "+menuItem.getDescription()+" - Rs."+menuItem.getPrice());
		}
	}
}
