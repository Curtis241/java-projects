package org.corp.model.converter;

import org.corp.model.DateType;
import org.corp.model.StockOption;
import org.joda.time.DateTime;

public class MarketPriceConverter implements Converter {

	@Override
	public StockOption convert(String[] parts, StockOption stockOption) {
		
		//expected format should be 20140101,1.00
		if(parts != null && stockOption != null) {
			//extract the contents of the string array and compose a MarketPrice object.
			DateTime marketPriceDate = new DateTime(parts[0]);
			String marketPriceDateString = parts[0];
			float marketPrice = Float.parseFloat(parts[1]);
			
			stockOption.setDate(marketPriceDate);
			stockOption.setDateString(marketPriceDateString);
			stockOption.setDateType(DateType.MarketPriceDate);
			stockOption.setMarketPrice(marketPrice);
		}
				
		return stockOption;
	}

}
