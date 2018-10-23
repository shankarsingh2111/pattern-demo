package com.example.shankar.patterndemo.iterator;

import android.util.Log;

import java.util.Iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("Diner 1", "Diner 1", true, 50);
		addItem("Diner 2", "Diner 2", true, 40);
		addItem("Diner 3", "Diner 3", false, 60);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		if (numberOfItems >= MAX_ITEMS) {
			Log.e("DinerMenu", "Menu full");
		} else {
			menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
			numberOfItems++;
		}
	}

	public Iterator createIterator(){
		return new DinerMenuIterator(menuItems, 0);
	}

}
