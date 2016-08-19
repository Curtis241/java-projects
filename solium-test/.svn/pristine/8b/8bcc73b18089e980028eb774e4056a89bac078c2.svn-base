package org.corp;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.corp.view.ConsoleViewImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	protected static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws IOException {
		logger.debug("Starting application");

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ConsoleViewImpl view = context.getBean(ConsoleViewImpl.class);
	    view.getInput();

	}
}
