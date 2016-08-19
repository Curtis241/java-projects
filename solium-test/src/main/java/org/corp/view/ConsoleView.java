package org.corp.view;

import java.io.IOException;
import java.util.ArrayList;

import org.corp.presenter.ConsolePresenter;

public interface ConsoleView {
	public void setPresenter(ConsolePresenter presenter);
	public void getInput() throws IOException;
	public ArrayList<String> getPipedInput() throws IOException;
	public void displayOutput(ArrayList<String> stringArray);
	
}
