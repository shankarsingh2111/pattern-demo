package com.example.shankar.patterndemo.template;

/**
 * Created by shankar on 07/06/17.
 */

public class BeverageTestDrive {

	public static void main(String[] args){
		Tea tea = new Tea();
		Coffee coffee = new Coffee();

		System.out.println("Making tea //////////");
		tea.prepareRecipe();

		System.out.println("Making coffee ///////");
		coffee.prepareRecipe();

	}

}
