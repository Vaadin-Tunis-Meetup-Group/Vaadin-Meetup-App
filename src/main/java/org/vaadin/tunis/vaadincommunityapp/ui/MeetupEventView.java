package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.model.Events;
import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.services.DateUtil;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class MeetupEventView extends NavigationView {
	public MeetupEventView(List<Events> meetupEvents, Group meetupGroup) {
		setCaption("Events");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		content.addStyleName("gray-background");
		for (Events event : meetupEvents) {
			Label time = new Label();
			time.setContentMode(ContentMode.HTML);

			StringBuilder timeValue = new StringBuilder();
			timeValue.append("<center><font size='-1' color='gray'>");
			timeValue.append(DateUtil.formatDate(event.getTime(), "hh:mm a"));
			timeValue.append("</font></center>");
			time.setValue(timeValue.toString());
			time.setWidth("90px");

			Label eventDescription = new Label();
			eventDescription.setContentMode(ContentMode.HTML);
			StringBuilder eventDescriptionValue = new StringBuilder();
			eventDescriptionValue.append("<div>");
			eventDescriptionValue.append("<font size='-1' color='gray'>");
			eventDescriptionValue.append(meetupGroup.getName());
			eventDescriptionValue.append("</font>");
			eventDescriptionValue.append("<br><b>");
			eventDescriptionValue.append(event.getName());
			eventDescriptionValue.append("</b><br>");
			eventDescriptionValue.append("<font size='-1' color='gray'>");
			eventDescriptionValue.append(event.getRsvpCount() + " going");
			eventDescriptionValue.append("</font>");
			eventDescriptionValue.append("</div>");
			eventDescription.setValue(eventDescriptionValue.toString());

			Label eventDate = new Label();
			eventDate.setContentMode(ContentMode.HTML);
			eventDate.setValue("<b>"
					+ DateUtil.formatDate(event.getTime(), "EEEE") + "</b> "
					+ DateUtil.formatDate(event.getTime(), "dd MMMM"));
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
