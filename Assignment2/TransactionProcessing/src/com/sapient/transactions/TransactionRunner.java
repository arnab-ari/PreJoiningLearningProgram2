package com.sapient.transactions;

import java.io.IOException;

public class TransactionRunner {

	public static void main(String[] args) throws IOException {
		String csvFile = "./resources/SampleInput.csv";
	    InputFileReader.readFile(csvFile);
        LogBook.printLog();
	}

}
