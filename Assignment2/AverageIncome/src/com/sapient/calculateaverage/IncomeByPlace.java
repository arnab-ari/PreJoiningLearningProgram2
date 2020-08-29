package com.sapient.calculateaverage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeByPlace implements Comparable<IncomeByPlace> {
	private String place;
	private double femaleIncome;
	private double maleIncome;
	private int femaleCount;
	private int maleCount;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getFemaleIncome() {
		return femaleIncome;
	}
	public void setFemaleIncome(double femaleIncome) {
		this.femaleIncome = femaleIncome;
	}
	public double getMaleIncome() {
		return maleIncome;
	}
	public void setMaleIncome(double maleIncome) {
		this.maleIncome = maleIncome;
	}
	public int getFemaleCount() {
		return femaleCount;
	}
	public void setFemaleCount(int femaleCount) {
		this.femaleCount = femaleCount;
	}
	public int getMaleCount() {
		return maleCount;
	}
	public void setMaleCount(int maleCount) {
		this.maleCount = maleCount;
	}
	
	public int compareTo(IncomeByPlace ibp) {
		if(place == null || ibp.getPlace() == null)
			return 0;
		else return place.compareTo(ibp.getPlace());
	}
	
	public double roundOff(double value,int places) {
		if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public double averageFemaleIncome() {
		return roundOff((femaleIncome / femaleCount),2);
	}
	
	public double averageMaleIncome() {
		return roundOff((maleIncome / maleCount),2);
	}
	@Override
	public String toString() {
		return "IncomeByPlace [place=" + place + ", femaleIncome=" + averageFemaleIncome() + ", maleIncome=" + averageMaleIncome()
				+ ", femaleCount=" + femaleCount + ", maleCount=" + maleCount + "]";
	}
	
}
