package com.shivendra.java8;

//Lambda expression removes your related class file which takes more time and space

interface A {
	void show();
}

public class LambdaExpression {

	public static void main(String[] args) {
		A obj;
		obj = () -> System.out.println("Hello");//Anonymous inner class through lambda 

		obj.show();

	}

}
