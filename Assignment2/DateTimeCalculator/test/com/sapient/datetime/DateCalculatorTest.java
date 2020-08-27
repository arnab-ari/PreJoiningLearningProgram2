package com.sapient.datetime;

import static org.junit.Assert.*;

import java.time.Month;

import org.junit.Before;
import org.junit.Test;



public class DateCalculatorTest {
	
	private DateCalculator dc;
	private MyDate date;
	@Before
	public void setup() {
		dc = new DateCalculator();
		date = new MyDate(28,8,2020);
	}

	@Test
	public void addDaysToShouldReturnAddedDate() {
		
	}
	
	@Test
	public void subtractDaysFromShouldReturnSubtractedDate() {
		assertEquals("2020-08-26",dc.subtractDaysFrom(date, 2).toString());
	}
	
	@Test
	public void todayShouldReturnCurrentDate() {
		assertEquals(new MyDate().toString(),dc.today().toString());
	}
	
	@Test
	public void tomorrowShouldReturnNextDate() {
		assertEquals(dc.addDaysTo(new MyDate(), 1).toString(),dc.tomorrow().toString());
	}
	
	@Test
	public void shouldReturnDayAfterTomorrow() {
		assertEquals(dc.addDaysTo(new MyDate(), 2).toString(),dc.dayAfterTomorrow().toString());
	}
	
	@Test
	public void shouldReturnYesterday() {
		assertEquals(dc.addDaysTo(new MyDate(), -1).toString(),dc.yesterday().toString());
	}
	
	@Test
	public void shouldReturnDayBeforeYesterday() {
		assertEquals(dc.addDaysTo(new MyDate(), -2).toString(),dc.dayBeforeYesterday().toString());
	}
	
	@Test
	public void shouldReturnNextMonth() {
		assertEquals("SEPTEMBER",dc.nextMonth());
	}
	
	@Test
	public void shouldReturnLastMonth() {
		assertEquals("JULY",dc.lastMonth());
	}
	
	@Test
	public void shouldReturnNextYear() {
		assertEquals(2021,dc.nextYear());
	}
	
	@Test
	public void shouldReturnLastYear() {
		assertEquals(2019,dc.lastYear());
	}
	
	/*
	
	public String lastMonth() {
		return Month.of(new MyDate().date.getMonthValue() - 1).toString();	
	}
	
	public int nextYear() {
		return (new MyDate().date.getYear() + 1);
	}
	
	public int lastYear() {
		return (new MyDate().date.getYear() - 1);
	}
	}*/

}
