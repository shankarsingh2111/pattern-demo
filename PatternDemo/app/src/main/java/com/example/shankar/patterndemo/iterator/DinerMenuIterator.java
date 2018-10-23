package com.example.shankar.patterndemo.iterator;

import java.util.Iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class DinerMenuIterator implements Iterator {
	MenuItem[] menuItems;
	int position = 0;

	public DinerMenuIterator(MenuItem[] menuItems, int position){
		this.menuItems = menuItems;
		this.position = position;
	}
	@Override
	public boolean hasNext() {
		return !(position >= menuItems.length || menuItems[position] == null);
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems[position];
		position++;
		return menuItem;
	}
}
