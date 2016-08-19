package org.corp.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.corp.presenter.ConsolePresenter;

public class ConsoleViewImpl implements ConsoleView {


	private ConsolePresenter presenter;

	public ConsoleViewImpl() {
		
	}

	@Override
	public void getInput() throws IOException {
		presenter.calculate(getPipedInput());
		
	}
	
	@Override
	public ArrayList<String> getPipedInput() throws IOException {
		
		BufferedReader in = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
	        String line;
	        while ((line = in.readLine()) != null) {
	            list.add(line);
	        }
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
	        if (in != null) {
	            in.close();
	        }
	    }
		
		return list;
	}

	@Override
	public void displayOutput(ArrayList<String> stringArray) {
		
		for(int i = 0; i < stringArray.size(); i++) {
			String message = stringArray.get(i).toString();
			System.out.println(message);
		}
		
	}

	@Override
	public void setPresenter(ConsolePresenter presenter) {
		this.presenter = presenter;
		
	}

	
}
