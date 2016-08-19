package org.corp.presenter;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.corp.model.StockOptionContainer;
import org.corp.model.StockOptionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-presenter-configuration.xml")
public class ConsolePresenterTests {

	@Autowired
	private ConsolePresenter presenter;
	
	@Autowired
	private StockOptionModel model;
	
	@Test
	public void deserializeTest() {
		
		ArrayList<String> stringArray = MockInputData.getVestStringArray();
		HashMap<String,StockOptionContainer> hashMap = presenter.deserialize(stringArray);
		
		assertNotNull(hashMap.get("001B"));
		assertNotNull(hashMap.get("002B"));
		assertNotNull(hashMap.get("003B"));

	}
	
	@Test
	public void deserializeWithEmptyArrayTest() {
		
		ArrayList<String> stringArray = new ArrayList<String>();
		HashMap<String,StockOptionContainer> hashMap = presenter.deserialize(stringArray);
		
		assertNotNull(hashMap);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deserializeWithNullArrayTest() {
		
		ArrayList<String> stringArray = null;
		presenter.deserialize(stringArray);

	}
	
	@Test
	public void calculateTest() {
		
		ArrayList<String> inputStringArray = MockInputData.getVestStringArray();
		ArrayList<String> outputStringArray = presenter.calculate(inputStringArray);
		
		assertNotNull(outputStringArray);
		assertTrue(outputStringArray.size() == 3);
		
		assertTrue("001B,1300.00".equals(outputStringArray.get(1)));
		assertTrue("002B,1325.00".equals(outputStringArray.get(0)));
		assertTrue("003B,500.00".equals(outputStringArray.get(2)));
		
	}
	
	@Test
	public void calculateWithModifiedDateTest() {
		
		ArrayList<String> inputStringArray = MockInputData.getModifiedVestStringArray();
		ArrayList<String> outputStringArray = presenter.calculate(inputStringArray);
		
		assertNotNull(outputStringArray);
		assertTrue(outputStringArray.size() == 3);
		
		assertTrue("001B,550.00".equals(outputStringArray.get(1)));
		assertTrue("002B,825.00".equals(outputStringArray.get(0)));
		assertTrue("003B,0.00".equals(outputStringArray.get(2)));
	}

	@Test
	public void calculateWithBadDataTest() {
		
		ArrayList<String> inputStringArray = MockInputData.getVestStringArrayWithBadData();
		ArrayList<String> outputStringArray = presenter.calculate(inputStringArray);
		
		assertNotNull(outputStringArray);
		assertTrue(outputStringArray.size() == 1);
		assertTrue(outputStringArray.get(0).equals("Validation Error: One or more entites provided are invalid"));
		
		
	}
	
	public void setPresenter(ConsolePresenter presenter) {
		this.presenter = presenter;
	}

	public void setModel(StockOptionModel model) {
		this.model = model;
	}
}
