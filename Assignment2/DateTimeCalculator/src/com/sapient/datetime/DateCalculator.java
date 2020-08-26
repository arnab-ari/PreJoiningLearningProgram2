package com.sapient.datetime;

public class DateCalculator {
	public void subtractDate(MyDate d1, MyDate d2) {	
		long difference = (d2.getEpochSeconds() - d1.getEpochSeconds())/86400;
		System.out.println("Difference of two dates in days is : " + difference );	
		
	}
	
	public MyDate addDaysTo(MyDate d,long n) {
		return new MyDate(d.date.plusDays(n));	
	}
	
	public MyDate subtractDaysFrom(MyDate d,long n) {
		return addDaysTo(d,-n);
	}
}
