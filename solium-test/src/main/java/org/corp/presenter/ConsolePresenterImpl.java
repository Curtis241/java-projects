package org.corp.presenter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.corp.model.StockOption;
import org.corp.model.StockOptionContainer;
import org.corp.model.StockOptionModel;
import org.corp.presenter.validator.Validator;
import org.corp.presenter.validator.ValidatorImpl;
import org.corp.view.ConsoleView;

public class ConsolePresenterImpl implements ConsolePresenter {

	protected static Logger logger = Logger.getLogger(ConsolePresenterImpl.class);
	private ConsoleView view;
	private StockOptionModel model;
	
	
	public ConsolePresenterImpl(ConsoleView view, StockOptionModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public HashMap<String, StockOptionContainer> deserialize(final ArrayList<String> stringArray) {
		
		//Only handle strings that are comma delimited, discard everything else. 
		//Validate that the strings are the correct format.
		//Identify the four different types of input objects.
			//1. VEST,001B,20120101,1000,0.45
			//2. PERF,001B,20130102,1.5
			//3. SALE,001B,20120402,500,1.00
			//4. 20140101,1.00
		//Deserialize the comma delimited string into VEST, PERF, SALE, and PRICE objects.
				
		if(stringArray == null) {
			throw new IllegalArgumentException();
		}
		
		if(stringArray.size() > 1) {
			model.map().clear();
			
			for(int i = 1; i < stringArray.size(); i++) {
				logger.debug(stringArray.get(i).toString());
				
				String[] parts = stringArray.get(i).split(",");		
				StockOption stockOption = model.convert(parts);
				model.set(stockOption);
			}
		}
		return model.map();
	
	}

	@Override
	public ArrayList<String> calculate(ArrayList<String> stringArray) {
		
		Validator validator = new ValidatorImpl();
		validator.validate(stringArray);
		
		if(validator.getSuccess() == false) {
			ArrayList<String> messages = validator.getMessages();
			view.displayOutput(messages);
			return messages;
		}
		
		deserialize(stringArray);
		
		ArrayList<String> stockOptionArray = new ArrayList<String>();
		
		if(model.map().keySet().size() > 1) {
			for(String employeeId:model.map().keySet()) {
				StockOptionContainer container = model.map().get(employeeId);
				logger.debug(MessageFormat.format("Calculating total gain for {0}",employeeId));
				
				container.calculateTotalGain();
				Float totalGain = container.getTotalGain();
				String totalGainString = String.format("%.2f", totalGain);
				String resultString = MessageFormat.format("{0},{1}",employeeId,totalGainString);
				logger.debug(resultString);
				
				stockOptionArray.add(resultString);
			}
			view.displayOutput(stockOptionArray);
		}

		return stockOptionArray;
		
	}

}
