package org.sakila.ws.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	private String dateTemplate = "yyyy-MM-dd";
	private SimpleDateFormat simpleDateFormatter;
	
	
	public DateFormatter() {
		simpleDateFormatter = new SimpleDateFormat(dateTemplate);
	}
	
	public String toDateString(Date date) {
		return simpleDateFormatter.format(date).toString();
	}
}
