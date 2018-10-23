package com.example.shankar.patterndemo.iterator;

/**
 * Created by shankar on 03/10/17.
 */

public class MenuTestDrive {

	public static void main(){
		Waitress waitress = new Waitress(new PancakeHouseMenu(), new DinerMenu());
		waitress.printMenu();
	}
}
