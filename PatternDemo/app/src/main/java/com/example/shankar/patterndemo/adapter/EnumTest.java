package com.example.shankar.patterndemo.adapter;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by shankar on 18/04/17.
 */

public class EnumTest {

	public static void main(){

		ArrayList<String> stringArrayList = new ArrayList<>();
		stringArrayList.add("hello");
		stringArrayList.add("i");
		stringArrayList.add("am");
		stringArrayList.add("test");

		IteratorEnumeration iteratorEnumeration = new IteratorEnumeration(stringArrayList.iterator());

		while(iteratorEnumeration.hasMoreElements()){
			Log.i("EnumTest", ">"+iteratorEnumeration.nextElement());
		}

	}

}
