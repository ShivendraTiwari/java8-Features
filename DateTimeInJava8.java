package com.shivendra.java8;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateTimeInJava8 {

	public static void main(String[] args) {

		LocalDateTime t = LocalDateTime.now(ZoneId.of("Australia/Tasmania"));
		System.out.println(t);
		
//		Instant i= Instant.now();
//		System.out.println();

		for (String s : ZoneId.getAvailableZoneIds()) {
			System.out.println(s);
		}
	}

}
