package org.corp.model;

import org.joda.time.DateTime;

public interface StockOption {

	//Client Information
	public StockOptionType getType();
	public void setType(StockOptionType type);
	public String getEmployeeId();
	public void setEmployeeId(String id);
	public void setDate(DateTime dateTime);
	public DateTime getDate();
	public void setDateString(String dateString);
	public String getDateString();
	public void setDateType(DateType dateType);
	public DateType getDateType();
	
	//Perf
	public void setMultiplier(float multiplier);
	public float getMultiplier();
	
	//Market Price
	public void setMarketPrice(Float marketPrice);
	public Float getMarketPrice();
	
	//Vest
	public int getUnits();
	public void setUnits(int units);
	public float getGrantPrice();
	public void setGrantPrice(float grantPrice);
	
	//Sale
	public void setAmountSold(int amountSold);
	public int getAmountSold();
	public void setSaleMarketPrice(float saleMarketPrice);
	public float getSaleMarketPrice();
	
	//Result
	public float getTotalGains();
	public void setTotalGains(float totalGains);
}
