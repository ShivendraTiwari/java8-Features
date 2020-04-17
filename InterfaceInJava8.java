package com.shivendra.java8;

interface Phone {
	void call();

	default void message() {
		System.out.println("sent");
	}

}

class AndroidPhone implements Phone {

	public void call() {
		System.out.println("Calling");
	}
}

public class InterfaceInJava8 {

	public static void main(String[] args) {

		Phone p = new AndroidPhone();
		p.call();
		p.message();
	}

}
