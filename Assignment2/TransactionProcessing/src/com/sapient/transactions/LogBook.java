package com.sapient.transactions;

import java.io.FileWriter;
import java.io.IOException;

public class LogBook {
	int cId;
	String tType;
	String tDate;
	boolean flag;
	int fee;
	public static String out = "";
	public LogBook(int cId, String tType, String tDate, boolean flag, int fee)
	{
		this.cId = cId;
		this.tDate = tDate;
		this.tType = tType;
		this.flag = flag;
		this.fee = fee;
	}
	public static void detailLog(String line)
	{
		String [] arr = line.split(",");
		System.out.println(arr[5]);
		if(arr[2].equals(""))
		{
			out  = out + arr[1] + "," + arr[3] + "," + arr[4] + "," + arr[6];
			if(arr[6].equals("N"))
				out = out + "," + "500";
			else
			{
				if(arr[3].equals("sell") || arr[3].equals("withdraw"))
					out = out + "," + "100";
				else
					out = out + "," + "50";
			}
			out = out + "\n";
		}
		else
		{
			out = out + arr[1] + "," + arr[3] + "," + arr[4] + "," + "N" +"," + "10" + "\n";
		}
	}
	public static void printLog() throws IOException
	{

		try{    
	        FileWriter fw=new FileWriter("./resources/outputlog.csv");    
	        fw.write(out);  
	        System.out.println(out);
	        fw.close();    
	       }catch(Exception e){System.out.println(e);}    
	       System.out.println("Log written to file."); 
	}


}
