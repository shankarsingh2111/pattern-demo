package com.example.shankar.patterndemo.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class PancakeHouseMenu {
	ArrayList menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList();

		addItem("Pancake 1", "Pancake 1", true, 10);
		addItem("Pancake 2", "Pancake 2", true, 20);
		addItem("Pancake 3", "Pancake 3", false, 30);
	}

	public void addItem(String name, String description, boolean vegetarian, double price){
		menuItems.add(new MenuItem(name, description, vegetarian,  price));
	}

	public Iterator createIterator(){
		return menuItems.iterator();
	}

}
