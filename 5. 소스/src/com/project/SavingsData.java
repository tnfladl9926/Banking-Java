package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SavingsData {
	
	public final static String SAVINGS = ".\\dat\\적금\\적금상품데이터.txt";
	
	public static ArrayList<Savings> List;
	
	static {
		List = new ArrayList<Savings>();
	}
	
	
	public static void savLoad() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(SavingsData.SAVINGS));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String temp[] = line.split(",");
				
				Savings s = new Savings(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				List.add(s);
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
