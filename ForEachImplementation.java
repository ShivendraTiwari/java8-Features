package com.shivendra.java8;

/* 
 * forEach loop is a part of collection so it is faster than
 * external for loop and they are used for huge amount of data
 * as they are faster.
 * */

import java.util.Arrays;
import java.util.List;

public class ForEachImplementation {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(4, 5, 6, 7, 8);

		//Normal for loop
		
//      for (int i = 0; i < values.size(); i++) {
//			System.out.println(values.get(i));
//		}

		//Enhanced for loop
//		for (int i : values) {
//			System.out.println(i);
//		}
		
		//ForEach loop(java 1.8)
		
		//values.forEach(System.out::println);
		
		//OR
		
		values.forEach(i->System.out.println(i));
	}

}
