package org.corp.model;

import java.util.HashMap;


public interface StockOptionModel {

	public StockOption convert(String[] parts);
	public HashMap<String,StockOptionContainer> map();
	public void set(StockOption stockOption);
	
}
