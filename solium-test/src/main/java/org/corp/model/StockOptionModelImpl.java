package org.corp.model;

import java.text.MessageFormat;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.corp.model.converter.Converter;
import org.corp.model.converter.MarketPriceConverter;
import org.corp.model.converter.VestConverter;


public class StockOptionModelImpl implements StockOptionModel {

	protected static Logger logger = Logger.getLogger(StockOptionModelImpl.class);
	private static HashMap<String,StockOptionContainer> hashMap;

	public StockOptionModelImpl() {
		hashMap = new HashMap<String,StockOptionContainer>();
	}
	
	@Override
	public StockOption convert(String[] parts) {
		
		String type = "";
		StockOption stockOption = new StockOptionImpl();
		
		if(parts != null && parts[0] != "") {
			type = parts[0];
			
			//Market Price Date looks like 20140101
			if(type.matches("([0-9]{8})")) {
				Converter converter = new MarketPriceConverter();
				stockOption.setType(StockOptionType.MARKETPRICE);
				stockOption = converter.convert(parts,stockOption);
			}
			//VEST object looks like VEST,001B,20120101,1000,0.45
			if(type.equals("VEST")) {
				Converter converter = new VestConverter();
				stockOption.setType(StockOptionType.VEST);
				stockOption = converter.convert(parts,stockOption);
			}
	
		}
		
		return stockOption;
	}

	@Override
	public HashMap<String, StockOptionContainer> map() {
		return hashMap;
	}

	@Override
	public void set(StockOption stockOption) {

		//Need to have a container for each employeeId.
		if(stockOption.getType() == StockOptionType.VEST) {
			StockOptionContainer container;
			
			//If a container already exists add the stock option to it
			//or make a new one if it does not.
			if(!hashMap.containsKey(stockOption.getEmployeeId())) {
				container = new StockOptionContainerImpl();
				hashMap.put(stockOption.getEmployeeId(), container);
				container.set(stockOption);
			} else {
				container = hashMap.get(stockOption.getEmployeeId());
				container.set(stockOption);
			}

		}
		
		//Need to put a market price object in every container that exists in the hashMap.
		if(stockOption.getType() == StockOptionType.MARKETPRICE) {
			
			logger.debug("HashMap keyset " + hashMap.keySet().toString());
			
			for(String key:hashMap.keySet()) {
				logger.debug(MessageFormat.format("Attempting to retrieve key {0} from hashmap",key));
				StockOptionContainer container = hashMap.get(key);
				
				Boolean exists = container.marketPriceExists();
				logger.debug(MessageFormat.format("Market price exists: {0} for {1}",exists,key));
				
				if(exists == false) {
					container.set(stockOption);
					logger.debug(MessageFormat.format("Adding market price object to {0}",key));
				}
			}
		}
		
	}

}
