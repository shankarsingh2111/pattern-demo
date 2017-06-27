package com.example.shankar.patterndemo.template;

/**
 * Created by shankar on 07/06/17.
 */

public abstract class CaffeineBeverage {

	/**
	 * this is a template function
	 */
	public final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()){
			addCondiments();
		}
	}
	abstract void brew();
	abstract void addCondiments();

	public void boilWater(){
		System.out.println("boilWater");
	}

	public void pourInCup(){
		System.out.println("pourInCup");
	}

	public boolean customerWantsCondiments(){
		return true;
	}

}
