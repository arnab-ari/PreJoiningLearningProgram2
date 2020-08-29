package com.sapient.calculateaverage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StoreInput {

	private List<IncomeByPlace> incomeList;

	public List<IncomeByPlace> getIncomeList() {
		return incomeList;
	}

	public StoreInput() {
		incomeList = new ArrayList<IncomeByPlace>();
	}

	public int ifExist(String place) {
		int result = -1;
		for (int i = 0; i < incomeList.size(); i++) {
			if (incomeList.get(i).getPlace().equals(place)) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	public double currencyConverter(String currency) {
		HashMap<String,Double> currencyMap = new HashMap<String,Double>();
		currencyMap.put("USD", 1.0d);
		currencyMap.put("INR", 1/66d);
		currencyMap.put("GBP", 1/0.67d);
		currencyMap.put("SGP", 1/1.5d);
		currencyMap.put("HKD", 1/8d);
		
		return currencyMap.get(currency);
	}
	public void readInput(String file) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line;
			boolean isCaption = true;
			while((line = br.readLine()) != null) {
				if(isCaption) {
					isCaption = false;
					continue;
				}
				
				String[] values = line.split(",");
				if(! values[1].equals("")) {
					if(ifExist(values[1]) != -1) {
						
						IncomeByPlace ibp = incomeList.get(ifExist(values[1]));
						if(values[2].equals("M")) {
							ibp.setMaleIncome(ibp.getMaleIncome() + Double.parseDouble(values[4]) * currencyConverter(values[3]));
							ibp.setMaleCount(ibp.getMaleCount() + 1);
						}
						else {
							ibp.setFemaleIncome(ibp.getFemaleIncome() + Double.parseDouble(values[4]) * currencyConverter(values[3]));
							ibp.setFemaleCount(ibp.getFemaleCount() + 1);
						}
							
					}
					else {
						IncomeByPlace ibp = new IncomeByPlace();
						ibp.setPlace(values[1]);
						if(values[2].equals("F")) {
							ibp.setFemaleCount(1);
							ibp.setFemaleIncome(Double.parseDouble(values[4]) * currencyConverter(values[3]));
						}
						else {
							ibp.setMaleCount(1);
							ibp.setMaleIncome(Double.parseDouble(values[4]) * currencyConverter(values[3]));
						}
						incomeList.add(ibp);	
					}
				}
				else {
					if(ifExist(values[0]) != -1) {
						IncomeByPlace ibp = incomeList.get(ifExist(values[0]));
						if(values[2].equals("M")) {
							ibp.setMaleIncome(ibp.getMaleIncome() + Double.parseDouble(values[4]) * currencyConverter(values[3]));
							ibp.setMaleCount(ibp.getMaleCount() + 1);
						}
						else {
							ibp.setFemaleIncome(ibp.getFemaleIncome() + Double.parseDouble(values[4]) * currencyConverter(values[3]));
							ibp.setFemaleCount(ibp.getFemaleCount() + 1);
						}
							
					}
					else {
						IncomeByPlace ibp = new IncomeByPlace();
						ibp.setPlace(values[0]);
						if(values[2].equals("F")) {
							ibp.setFemaleCount(1);
							ibp.setFemaleIncome(Double.parseDouble(values[4]) * currencyConverter(values[3]));
						}
						else {
							ibp.setMaleCount(1);
							ibp.setMaleIncome(Double.parseDouble(values[4]) * currencyConverter(values[3]));
						}
						incomeList.add(ibp);	
					}
				}
				Collections.sort(incomeList);
			}
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally {
			try {
				fr.close();
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
	
	public void writeOutput(String file) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("Contry/City,Genger,AverageIncome(In USD)");
			bw.newLine();
			for(IncomeByPlace ibp : incomeList) {
				String str1 = ibp.getPlace() + "," + "F," + ibp.averageFemaleIncome();
				String str2 = ibp.getPlace() + "," + "M," + ibp.averageMaleIncome();
				bw.append(str1);
				bw.newLine();
				bw.append(str2);
				bw.newLine();
			}
			System.out.println("Output written to Output3.csv");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
