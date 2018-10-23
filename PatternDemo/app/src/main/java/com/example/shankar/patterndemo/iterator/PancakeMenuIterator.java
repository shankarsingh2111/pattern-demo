package com.example.shankar.patterndemo.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class PancakeMenuIterator implements Iterator {
	ArrayList menuItems;
	int position = 0;

	public PancakeMenuIterator(ArrayList menuItems, int position){
		this.menuItems = menuItems;
		this.position = position;
	}
	@Override
	public boolean hasNext() {
		return !(position >= menuItems.size() || menuItems.get(position) == null);
	}

	@Override
	public Object next() {
		MenuItem menuItem = (MenuItem) menuItems.get(position);
		position++;
		return menuItem;
	}
}
