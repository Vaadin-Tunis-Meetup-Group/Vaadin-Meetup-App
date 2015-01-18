package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.Date;
import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.services.DateUtil;
import org.vaadin.tunis.vaadincommunityapp.services.google.calendar.GoogleCalendarService;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class EventsView extends NavigationView {

	public EventsView() throws Exception {
		setCaption("Events");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();
		List<com.google.api.services.calendar.model.Event> events = GoogleCalendarService
				.getAllVaadinEvent();
		DateUtil.sortByStartDate(events);
		content.addStyleName("gray-background");
		for (com.google.api.services.calendar.model.Event event : events) {
			Label time = new Label();
			time.setContentMode(ContentMode.HTML);

			StringBuilder timeValue = new StringBuilder();
			timeValue.append("<center><font size='-1' color='gray'>");
			Date startDate;
			if (event.getStart().getDateTime() != null) {
				startDate = new Date(event.getStart().getDateTime().getValue());
				timeValue.append(DateUtil.formatDate(startDate, "hh:mm a"));
			} else {
				startDate = new Date(event.getStart().getDate().getValue());
				timeValue.append(DateUtil.formatDate(startDate, "hh:mm a"));
			}
			timeValue.append("<br>");
			Date endDate;
			if (event.getEnd().getDateTime() != null) {
				endDate = new Date(event.getEnd().getDateTime().getValue());
				timeValue.append(DateUtil.formatDate(endDate, "hh:mm a"));
			} else {
				endDate = new Date(event.getEnd().getDate().getValue());
				timeValue.append(DateUtil.formatDate(endDate, "hh:mm a"));
			}

			timeValue.append("</font></center>");
			time.setValue(timeValue.toString());
			time.setWidth("90px");
			Label eventDescription = new Label();
			eventDescription.setContentMode(ContentMode.HTML);
			StringBuilder eventDescriptionValue = new StringBuilder();
			eventDescriptionValue.append("<div>");
			eventDescriptionValue.append("<b>");
			eventDescriptionValue.append(event.getSummary());
			eventDescriptionValue.append("</b><br>");
			eventDescriptionValue.append("<font size='-1' color='gray'>");
			eventDescriptionValue.append(event.getDescription());
			eventDescriptionValue.append("</font>");
			eventDescriptionValue.append("</div>");
			eventDescription.setValue(eventDescriptionValue.toString());

			Label eventDate = new Label();
			eventDate.setContentMode(ContentMode.HTML);
			eventDate.setValue("<b>" + DateUtil.formatDate(startDate, "EEEE")
					+ "</b> " + DateUtil.formatDate(startDate, "dd MMMM")
					+ " - " + "<b>" + DateUtil.formatDate(startDate, "EEEE")
					+ "</b> " + DateUtil.formatDate(startDate, "dd MMMM"));
			RowOfData dateRowData = new RowOfData(eventDate);

			RowOfData rowOfData = new RowOfData(time, eventDescription, event);
			rowOfData.addStyleName("left-decorated-label");
			rowOfData.addStyleName("upcoming-event-left-decorated-label");
			rowOfData.setSpacing(false);
			rowOfData.setHeight("80px");
			content.addComponent(dateRowData);
			content.addComponent(rowOfData);
		}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);

	}
}
