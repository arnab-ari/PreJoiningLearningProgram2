package com.sapient.datetime;


public class DateCalculatorRunner {
	public static void main(String[] args) {		
		DateCalculator dc = new DateCalculator();	
		MyDate d1 = new MyDate();
		MyDate d2 = new MyDate(31,12,2020);
		MyDate d3 = new MyDate("01/01/2021");
		dc.subtractDate(d1, d2);
		System.out.println("126 days from now:");
		System.out.println(dc.addDaysTo(d1, 126));
		System.out.println("128 days before 01/01/2021: ");
		System.out.println(dc.subtractDaysFrom(d3, 127));	
	}
	
	
}
