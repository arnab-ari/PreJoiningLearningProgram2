package com.sapient.datetime;

import java.time.Month;

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
	
	public MyDate today() {
		return new MyDate();
	}
	
	public MyDate tomorrow() {
		return addDaysTo(new MyDate(),1);
	}
	
	public MyDate dayAfterTomorrow() {
		return addDaysTo(new MyDate(),2);
	}
	
	public MyDate yesterday() {
		return subtractDaysFrom(new MyDate(),1);
	}
	
	public MyDate dayBeforeYesterday() {
		return subtractDaysFrom(new MyDate(),2);
	}
	
	public String nextMonth() {
		return Month.of(new MyDate().date.getMonthValue() + 1).toString();	
	}
	
	public String lastMonth() {
		return Month.of(new MyDate().date.getMonthValue() - 1).toString();	
	}
	
	public int nextYear() {
		return (new MyDate().date.getYear() + 1);
	}
	
	public int lastYear() {
		return (new MyDate().date.getYear() - 1);
	}
	
	void performOperation(int option) {
		switch(option) {
			case 1:
				System.out.println(today());
				break;
				
			case 2:
				System.out.println(tomorrow());
				break;
			
			case 3:
				System.out.println(dayAfterTomorrow());
				break;
			
			case 4:
				System.out.println(yesterday());
				break;
				
			case 5:
				System.out.println(dayBeforeYesterday());
				break;
				
			case 6:
				System.out.println(nextMonth());
				break;
				
			case 7:
				System.out.println(lastMonth());
				break;
				
			case 8:
				System.out.println(nextYear());
				break;
				
			case 9:
				System.out.println(lastYear());
				break;
			
			default:
				System.out.println("Error: INVALID OPTION !!!!");
		}
	}
}
//   Last week, Previous week, Next week,  Month after, Month before, n weeks from now, n days from now, n months from now, n years from now, n days earlier, n weeks earlier, n months earlier, n years earlier