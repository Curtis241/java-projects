package org.corp.presenter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.corp.presenter.validator.Validator;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-presenter-configuration.xml")
public class ValidationTests {

	@Autowired
	private Validator validator;

	@Test
	public void validationTest() {
		
		ArrayList<String> stockOptionArrayList = MockInputData.getVestStringArray();
		validator.validate(stockOptionArrayList);
		
		assertTrue(validator.getSuccess() == true);
	}
	
	@Test
	public void validationWithBadDataTest() {
		
		ArrayList<String> stockOptionArrayList = MockInputData.getVestStringArrayWithBadData();
		validator.validate(stockOptionArrayList);
		
		assertTrue(validator.getSuccess() == false);
	}
	
	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	
}
