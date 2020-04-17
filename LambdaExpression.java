package com.shivendra.java8;

//Lambda expression removes your related class file which takes more time and space

interface A {
	void show();
}

//class Xyz implements A {
//	public void show() {
//		System.out.println("Hello");
//	}
//}

public class LambdaExpression {

	public static void main(String[] args) {
		A obj;
		
//		Obj=new A() {
//			public void show() {
//				System.out.println("Hello");
//			}
//		}
		
		obj = () -> System.out.println("Hello");// Anonymous inner class through lambda

		obj.show();

	}

}
