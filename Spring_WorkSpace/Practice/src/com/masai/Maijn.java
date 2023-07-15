package com.masai;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Maijn {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.parse("2023-03-03");
		LocalDate date2 = LocalDate.parse("2023-04-03");
		
		long i = ChronoUnit.DAYS.between(date1, date2);
		
		System.out.println(i);
	}
}
