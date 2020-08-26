package com.sapient.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
public class MyDate {
	 LocalDate date;
	
	public MyDate() {
		date = LocalDate.now();
	}
	
	public MyDate(int day,int month,int year) {
		date = LocalDate.of(year, month, day);
	}
	
	public MyDate(String s) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String[] values = s.split("\\.|-|/");
		String d = values[2] + "/" + values[1] + "/" + values[0];
		date = LocalDate.parse(d,df);
	}
	
	public MyDate(LocalDate d) {
		this.date = d;
	}
	
	public long getEpochSeconds() {
		long s = date.toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.of("Z"));
		return s;
	}
	
	
	@Override
	public String toString() {
		return date.toString();
	}
}

