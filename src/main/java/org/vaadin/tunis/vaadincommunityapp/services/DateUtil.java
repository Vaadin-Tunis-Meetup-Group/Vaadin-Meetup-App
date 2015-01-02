package org.vaadin.tunis.vaadincommunityapp.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private DateUtil() {
		// fix sonar violation
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static Date getCalendarStartDate(){
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar(date.getYear(), date.getMonth(), 1);
		return new Date(gc.getTime().getTime());
	}
	
	public static Date getCalendarEndDate(){
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar(date.getYear(), date.getMonth()+2, 1);
		return new Date(gc.getTime().getTime());
	}
}
