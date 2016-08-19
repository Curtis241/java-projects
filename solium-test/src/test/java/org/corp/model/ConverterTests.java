package org.corp.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-model-configuration.xml")
public class ConverterTests {

	@Autowired
	StockOptionModel model;
	
	@Test
	public void convertWithOkValuesTest() {

		String[] parts = getVestArray();
		StockOption stockOption = model.convert(parts);
		
		assertNotNull(stockOption);
		assertTrue(stockOption.getEmployeeId() instanceof String);
		assertTrue(stockOption.getDate() instanceof DateTime);
		assertTrue(Integer.parseInt(parts[3]) == stockOption.getUnits());
		assertTrue(Float.parseFloat(parts[4]) == stockOption.getGrantPrice());
			
	}
	
	@Test
	public void convertWithMissingType() {
		
		String[] parts = getVestArray();
		parts[0] = "";
		
		StockOption stockOption = model.convert(parts);
		
		assertNotNull(stockOption);
		assertTrue(stockOption.getEmployeeId() == null);
		
		
	}
	
	private String[] getVestArray() {
		return new String[] {"VEST","001B","20120101","1000","0.45"};
	}
	
}
