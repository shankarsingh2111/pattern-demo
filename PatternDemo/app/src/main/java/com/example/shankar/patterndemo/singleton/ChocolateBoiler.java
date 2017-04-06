package com.example.shankar.patterndemo.singleton;

/**
 * Created by shankar on 06/04/17.
 */

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;

	private volatile static ChocolateBoiler instance;// = new ChocolateBoiler();	// eagerly created instance

	private ChocolateBoiler(){
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance(){
		if(instance == null){	// lazily created instance
			synchronized (ChocolateBoiler.class){
				if(instance == null){
					instance = new ChocolateBoiler();
				}
			}
			instance = new ChocolateBoiler();
		}
		return instance;
	}

	public void fill(){
		if(isEmpty()){
			empty = false;
			boiled = false;
			// fill boiler with milk chocolate
		}
	}

	public void drain(){
		if(!isEmpty() && isBoiled()){
			// drain boiled milk chocolate
			empty = true;
		}
	}

	public void boil(){
		if(!isEmpty() && !isBoiled()){
			// bring contents to boil
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}
}
