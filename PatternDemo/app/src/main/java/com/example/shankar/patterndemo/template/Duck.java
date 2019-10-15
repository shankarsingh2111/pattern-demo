package com.example.shankar.patterndemo.template;

import androidx.annotation.NonNull;

/**
 * Created by shankar on 29/09/17.
 */

public class Duck implements Comparable {
	int weight;

	public Duck(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(@NonNull Object o) {
		if(o instanceof Duck){
			return weight - ((Duck)o).weight;
		}
		return 0;
	}
}
