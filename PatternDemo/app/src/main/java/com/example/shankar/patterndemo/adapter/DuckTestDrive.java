package com.example.shankar.patterndemo.adapter;

/**
 * Created by shankar on 17/04/17.
 */

public class DuckTestDrive {

	public static void main(String[] args){
		MallardDuck mallardDuck = new MallardDuck();
		WildTurkey wildTurkey = new WildTurkey();
		Duck duckAdapter = new TurkeyAdapter(wildTurkey);

		wildTurkey.gobble();
		wildTurkey.fly();

		testDuck(mallardDuck);

		testDuck(duckAdapter);

	}

	private static void testDuck(Duck duck){
		duck.quack();
		duck.fly();
	}

}
