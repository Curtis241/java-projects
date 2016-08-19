package org.corp.model;

import org.joda.time.DateTime;

public class StockOptionImpl implements StockOption {

	private StockOptionType stockOptionType;
	private String employeeId;
	private DateTime date;
	private String dateString;
	private DateType dateType;
	//Vest
	private int units;
	private float grantPrice;
	//Market Price
	private float marketPrice;

	//Perf
	
	
	//Sale
	
	
	//Results
	private float totalGains;
	
	
	@Override
	public StockOptionType getType() {
		return this.stockOptionType;
	}
	
	@Override
	public void setType(StockOptionType type) {
		this.stockOptionType = type;
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public void setEmployeeId(String id) {
		this.employeeId = id;
	}

	@Override
	public int getUnits() {
		return this.units;
	}

	@Override
	public void setUnits(int units) {
		this.units = units;

	}

	@Override
	public float getGrantPrice() {
		return this.grantPrice;
	}

	@Override
	public void setGrantPrice(float grantPrice) {
		this.grantPrice = grantPrice;

	}

	@Override
	public DateTime getDate() {
		return this.date;
	}

	@Override
	public void setDate(DateTime date) {
		this.date = date;

	}

	@Override
	public void setMultiplier(float multiplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAmountSold(int amountSold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAmountSold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSaleMarketPrice(float saleMarketPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getSaleMarketPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
		
	}

	@Override
	public Float getMarketPrice() {
		return this.marketPrice;
	}

	@Override
	public void setDateType(DateType dateType) {
		this.dateType = dateType;
		
	}

	@Override
	public DateType getDateType() {
		return this.dateType;
	}

	@Override
	public void setDateString(String dateString) {
		this.dateString = dateString;
		
	}

	@Override
	public String getDateString() {
		return this.dateString;
	}

	@Override
	public float getTotalGains() {
		return totalGains;
	}

	@Override
	public void setTotalGains(float totalGains) {
		this.totalGains = totalGains;
	}

}
