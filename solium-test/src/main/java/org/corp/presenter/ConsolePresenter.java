package org.corp.presenter;

import java.util.ArrayList;
import java.util.HashMap;

import org.corp.model.StockOptionContainer;

public interface ConsolePresenter {
	public ArrayList<String> calculate(ArrayList<String> stringArray);
	public HashMap<String, StockOptionContainer> deserialize(ArrayList<String> stringArray);
	
}

