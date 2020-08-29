package com.sapient.calculateaverage;


public class AverageIncomeRunner {

	public static void main(String[] args) {
		String file = "./resources/SampleInput3.csv";
		String output = "./resources/Output3.csv";
		StoreInput si = new StoreInput();
		si.readInput(file);
		si.writeOutput(output);
		
	}

}
