package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.vaadin.tunis.vaadincommunityapp.services.DateUtil;
import org.vaadin.tunis.vaadincommunityapp.services.google.calendar.GoogleCalendarService;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.event.BasicEvent;

@SuppressWarnings("serial")
public class EventsView extends NavigationView {

	public EventsView() {
		setCaption("Events");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();
		List<com.google.api.services.calendar.model.Event> events = GoogleCalendarService
				.getAllVaadinEvent();

		Calendar calendar = new Calendar();
		calendar.setSizeFull();
		calendar.setLocale(Locale.getDefault());
		calendar.setImmediate(true);
		calendar.setFirstVisibleHourOfDay(7);
		calendar.setLastVisibleHourOfDay(23);

		content.addComponent(calendar);
		setContent(content);

		// Use a container of built-in BasicEvents
		final BeanItemContainer<BasicEvent> container = new BeanItemContainer<BasicEvent>(
				BasicEvent.class);

		for (com.google.api.services.calendar.model.Event event : events) {
			BasicEvent basicEvent = new BasicEvent();
			basicEvent.setCaption(event.getSummary());
			basicEvent.setDescription(event.getDescription());
			if (event.getStart().getDateTime() != null) {
				basicEvent.setStart(new Date(event.getStart().getDateTime()
						.getValue()));
			} else {
				basicEvent.setStart(new Date(event.getStart().getDate()
						.getValue()));
			}
			if (event.getEnd().getDateTime() != null) {
				basicEvent.setEnd(new Date(event.getEnd().getDateTime()
						.getValue()));
			} else {
				basicEvent
						.setEnd(new Date(event.getEnd().getDate().getValue()));
			}

			container.addBean(basicEvent);
		}
		container.sort(new Object[] { "start" }, new boolean[] { true });
		calendar.setContainerDataSource(container, "caption", "description",
				"start", "end", "styleName");
	}
}
