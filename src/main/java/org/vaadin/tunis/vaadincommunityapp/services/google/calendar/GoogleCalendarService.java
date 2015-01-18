package org.vaadin.tunis.vaadincommunityapp.services.google.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class GoogleCalendarService {
	private static GoogleCalendarAPIServiceFactory apiServiceFactory = GoogleCalendarAPIServiceFactory
			.getInstance();
	private static List<Event> ALL_EVENTS = new ArrayList<Event>();

	private GoogleCalendarService() {

	}

	public static List<Event> getAllVaadinEvent() {
		if (ALL_EVENTS.isEmpty()) {

			String pageToken = null;
			Date today = new Date();
			do {
				try {
					Events events = apiServiceFactory.service
							.events()
							.list("c9pprt0v3mkrp9dvmk395q9j8s@group.calendar.google.com")
							.setPageToken(pageToken)
							.execute();
					List<Event> items = events.getItems();
					for (Event event : items) {
						Date startDate;
						if (event.getStart().getDateTime() != null) {
							startDate = new Date(event.getStart().getDateTime()
									.getValue());
						} else {
							startDate = new Date(event.getStart().getDate()
									.getValue());
						}

						if (startDate.after(today)) {
							ALL_EVENTS.add(event);
						}
					}
					pageToken = events.getNextPageToken();
				} catch (Exception e) {
				}
			} while (pageToken != null);
		}
		return ALL_EVENTS;
	}
}
