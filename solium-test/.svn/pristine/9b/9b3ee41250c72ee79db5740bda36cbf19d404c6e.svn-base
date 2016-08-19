package org.corp.presenter;

import java.util.ArrayList;

public abstract class MockInputData {

	public static ArrayList<String> getVestStringArray() {
		
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("5");
		stringArray.add("VEST,001B,20120101,1000,0.45");
		stringArray.add("VEST,002B,20120101,1500,0.45");
		stringArray.add("VEST,002B,20130101,1000,0.50");
		stringArray.add("VEST,001B,20130101,1500,0.50");
		stringArray.add("VEST,003B,20130101,1000,0.50");
		stringArray.add("20140101,1.00");
		
		return stringArray;
	}

	public static ArrayList<String> getModifiedVestStringArray() {
		
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("5");
		stringArray.add("VEST,001B,20120101,1000,0.45");
		stringArray.add("VEST,002B,20120101,1500,0.45");
		stringArray.add("VEST,002B,20130101,1000,0.50");
		stringArray.add("VEST,001B,20130101,1500,0.50");
		stringArray.add("VEST,003B,20130101,1000,0.50");
		stringArray.add("20120615,1.00");
		
		return stringArray;
	}
	
	public static ArrayList<String> getVestStringArrayWithBadData() {
		
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("5");
		stringArray.add("VEGT,001B,20120101,1000,0.45");
		stringArray.add("VEST,002B,20120101,1500,0.45");
		stringArray.add("VEST,002B,20130101,1000,0.50");
		stringArray.add("VEST,001B,20130101,1500,0.50");
		stringArray.add("VEST,003B,20130101,1000,0.50");
		stringArray.add("20140101,1.00");
		
		return stringArray;
	}
}
