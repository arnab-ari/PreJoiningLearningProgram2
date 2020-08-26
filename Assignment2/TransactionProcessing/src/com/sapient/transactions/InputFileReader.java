package com.sapient.transactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFileReader {
	public static void readFile(String csvFile) {
		FileReader ifr = null;
		BufferedReader br = null;
		File file = new File(csvFile);
		try {
			ifr = new FileReader(file);
			br = new BufferedReader(ifr);
			String line;
			String [] storeLine;
			while((line = br.readLine()) != null) {
				LogBook.detailLog(line);
				storeLine = line.split(",");
				for(String str : storeLine) {
					System.out.print(str + " ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ifr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
