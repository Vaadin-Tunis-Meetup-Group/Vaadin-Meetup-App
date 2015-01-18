package org.vaadin.tunis.vaadincommunityapp.services;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.api.services.calendar.model.Event;

public class DateUtil {

	private DateUtil() {
		// fix sonar violation
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date getCalendarStartDate() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar(date.getYear(),
				date.getMonth(), 1);
		return new Date(gc.getTime().getTime());
	}

	public static Date getCalendarEndDate() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar(date.getYear(),
				date.getMonth() + 2, 1);
		return new Date(gc.getTime().getTime());
	}

	public static void sortByStartDate(List<Event> events) {
		Collections.sort(events, new Comparator<Event>() {

			@Override
			public int compare(Event event1, Event event2) {
				Date startDate1;
				if (event1.getStart().getDateTime() != null) {
					startDate1 = new Date(event1.getStart().getDateTime()
							.getValue());
				} else {
					startDate1 = new Date(event1.getStart().getDate()
							.getValue());
				}
				Date startDate2;
				if (event2.getStart().getDateTime() != null) {
					startDate2 = new Date(event2.getStart().getDateTime()
							.getValue());
				} else {
					startDate2 = new Date(event2.getStart().getDate()
							.getValue());
				}
				if (startDate1.getTime() < startDate2.getTime()) {
					return -1;
				} else if (startDate1.getTime() == startDate2.getTime()) {
					return 0;
				} else {
					return 1;
				}

			}
		});
	}
}
