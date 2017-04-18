package com.example.shankar.patterndemo.adapter;

/**
 * Created by shankar on 17/04/17.
 */

public class DuckAdapter implements Turkey {

	Duck duck;

	public DuckAdapter(Duck duck){
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}
}
