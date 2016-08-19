package org.corp.model.converter;

import org.corp.model.DateType;
import org.corp.model.StockOption;
import org.joda.time.DateTime;

public class VestConverter implements Converter {

	@Override
	public StockOption convert(String[] parts, StockOption stockOption) {
		
		//expected format should be VEST,001B,20120101,1000,0.45
		if(parts != null && stockOption != null) {
			//extract the contents of the string array and compose a Vest object.
			String id = parts[1];
			DateTime vestDate = new DateTime(parts[2]);
			String vestDateString = parts[2];
			int units = Integer.parseInt(parts[3]);
			float grantPrice = Float.parseFloat(parts[4]);
			
			stockOption.setEmployeeId(id);
			stockOption.setDate(vestDate);
			stockOption.setDateString(vestDateString);
			stockOption.setDateType(DateType.VestDate);
			stockOption.setUnits(units);
			stockOption.setGrantPrice(grantPrice);
		}
	

		return stockOption;
	}

}
