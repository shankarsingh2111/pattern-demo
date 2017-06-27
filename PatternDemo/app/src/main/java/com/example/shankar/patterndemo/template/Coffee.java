package com.example.shankar.patterndemo.template;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shankar on 07/06/17.
 */

public class Coffee extends CaffeineBeverage{

	public void brew(){
		System.out.println("brewCoffeeGrinds");
	}

	public void addCondiments(){
		System.out.println("addSugarAndMilk");
	}

	@Override
	public boolean customerWantsCondiments() {
		System.out.println("customerWantsCondiments used");
		String answer = getUserInput();

		if(answer.toLowerCase().startsWith("y")){
			return true;
		} else {
			return false;
		}
	}

	private String getUserInput(){
		String answer = "no";

		System.out.println("Would you like milk and sugar with your coffee (y/n) ?");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try{
			answer = in.readLine();
			return answer;
		} catch (Exception e){
			return answer;
		}
	}
}
