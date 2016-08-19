package org.corp.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

public class StockOptionContainerImpl implements StockOptionContainer {

	protected static Logger logger = Logger.getLogger(StockOptionContainerImpl.class);
	private ArrayList<StockOption> stockOptions;
	private float totalGains;
	
	
	public StockOptionContainerImpl() {
		stockOptions = new ArrayList<StockOption>();
	}
	
	@Override
	public void set(StockOption stockOption) {
		stockOptions.add(stockOption);
		//Automatically sort all objects by date.
		sortByDate();
	}

	@Override
	public void sortByDate() {
		//Reference: http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
		Collections.sort(stockOptions, new Comparator<StockOption>() {
			  public int compare(StockOption o1, StockOption o2) {
			      if (o1.getDate() == null || o2.getDate() == null)
			        return 0;
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
	}

	@Override
	public void calculateTotalGain() {
		
		//TODO: Make sure to change this if there are PERF or SALE objects.
		if(stockOptions != null) {
			if(stockOptions.size() > 0) {

				StockOption mp = getMarketPriceObject();
				float marketPrice = mp.getMarketPrice();
				DateTime marketPriceDate = mp.getDate();
				
				logger.debug(MessageFormat.format("Working with {0} stock options",stockOptions.size()));
				
				for(StockOption so:stockOptions) {
					if(so.getType() != StockOptionType.MARKETPRICE) {

						if((so.getDate().isBefore(marketPriceDate))) {
							float grantPrice = so.getGrantPrice();
							float priceResult = marketPrice - grantPrice;
							logger.debug(MessageFormat.format("Price result calculation: Market Price {0} - Grant Price {1} = {2}",marketPrice,grantPrice,priceResult));
							
							int units = so.getUnits();
							int totalGains = Math.round(units * priceResult);
							logger.debug(MessageFormat.format("Total gains calculation: Units {0} * Price Result {1} = {2}", units,priceResult,totalGains));
							
							so.setTotalGains(totalGains);
						}
					}
				}
			}
		}

	}

	@Override
	public float getTotalGain() {
	
		if(stockOptions != null) {
			if(stockOptions.size() > 1) {
				for(StockOption so:stockOptions) {
					this.totalGains = this.totalGains + so.getTotalGains();
				}
			}
		}

		return this.totalGains;
	}

	@Override
	public float getMarketPrice() {
		
		float marketPrice = 0.0f;
		StockOption so = getMarketPriceObject();
		
		if(so != null) {
			marketPrice = so.getMarketPrice();
		}
		
		return marketPrice;
	}

	@Override
	public boolean marketPriceExists() {
		if(getMarketPrice()== 0.0f) {
			return false;
		}
		return true;
	}

	@Override
	public StockOption getMarketPriceObject() {
		StockOption selectedStockOption = null;
		
		if(stockOptions != null) {
			for(StockOption stockOption:stockOptions) {
				if(stockOption.getType() == StockOptionType.MARKETPRICE) {
					selectedStockOption = stockOption;
				}
			}
		}
		return selectedStockOption;
	}

}

//Vested

//Get all VEST objects where vest date is less than the market date.
//Total Gain per Vested = MarketPrice - GrantPrice
//Multiply units and Total Gain Per Vested for each StockOption object to get the total gain.
//Add all total gains for all StockOption objects.
//Create string that looks like 001B,1300.00 (Employee Id, Total Gains)

//Perf

//Find all PERF objects and increment the units by the multiplier for all objects that have a vest date less
//than the bonus effective date.

//Sale

//Calculate result of any PERF objects that occur before sale date.
//Total the number of units at time of sale date.
//Decrease the total number of units by amount of units sold.
//Calculate total gain through sale.
//Create string that looks like 001B,1300.00,500 (Employee Id, Total Gains, Total Gains through Sale)
