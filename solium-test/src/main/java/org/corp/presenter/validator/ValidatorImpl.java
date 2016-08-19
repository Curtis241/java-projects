package org.corp.presenter.validator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;


public class ValidatorImpl implements Validator {

	protected static Logger logger = Logger.getLogger(ValidatorImpl.class);
	private boolean success = true;
	private ArrayList<String> messages;
	
	public ValidatorImpl() {
		messages = new ArrayList<String>();
	}
	
	@Override
	public boolean getSuccess() {
		return this.success;
	}

	@Override
	public ArrayList<String> getMessages() {
		return this.messages;
	}

	
	private Hashtable<Integer,Strategy> VestValidatorTable() {
		Hashtable<Integer,Strategy> validations = new Hashtable<Integer,Strategy>();
		validations.put(0, new TypeValidator());
		validations.put(1, new EmployeeIdValidator());
		validations.put(2, new VestDateValidator());
		validations.put(3, new UnitValidator());
		validations.put(4, new GrantPriceValidator());
		return validations;
	}
	
	private Hashtable<Integer,Strategy> MarketPriceValidatorTable() {
		Hashtable<Integer,Strategy> validations = new Hashtable<Integer,Strategy>();
		validations.put(0, new MarketPriceDateValidator());
		validations.put(1, new MarketPriceValidator());
		return validations;
	}
	
	private Boolean isVestStringValid(Integer index,String entity) {
		Context context = new Context(VestValidatorTable().get(index));
		return context.executeStrategy(entity);
	}
	
	private Boolean isMarketPriceStringValid(Integer index,String entity) {
		Context context = new Context(MarketPriceValidatorTable().get(index));
		return context.executeStrategy(entity);
	}
	
	@Override
	public void validate(ArrayList<String> stockOptionArrayList) {
		
		ArrayList<Boolean> validateResult = new ArrayList<Boolean>();
		Boolean isValid = false;
				
		for(String stockOptionString:stockOptionArrayList) {
			String[] parts = stockOptionString.split(",");
			
			//Vest Stock Option Validation
			if(parts.length > 2) {
				for(int i=0;i<parts.length;i++) {
					isValid = isVestStringValid(i,parts[i]);
					validateResult.add(isValid);
					logger.debug(MessageFormat.format("{0} validation {1}",parts[i], isValid));
				}
			}
			//Market Price Validation
			if(parts.length == 2) {
				for(int i=0;i<parts.length;i++) {
					isValid = isMarketPriceStringValid(i,parts[i]);
					validateResult.add(isValid);
					logger.debug(MessageFormat.format("{0} validation {1}",parts[i], isValid));
				}
			}
		}
		
		for(Boolean result:validateResult) {
			if(result == false) {
				this.success = false;
				this.messages.add("Validation Error: One or more entites provided are invalid");
			}
		}
			
	}

}
