package com.example.shankar.patterndemo.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by shankar on 18/04/17.
 */

public class EnumerationIterator implements Iterator {
	Enumeration enumeration;
	public EnumerationIterator(Enumeration enumeration){
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
