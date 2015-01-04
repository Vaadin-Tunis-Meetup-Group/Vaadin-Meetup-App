package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.List;

import meetup.Group;

import org.vaadin.tunis.vaadincommunityapp.services.meetupapi.MeetupsService;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class MeetupsView extends NavigationView {
	private static String MEETUP_ICON = "icons/meetup-icon.png";

	public MeetupsView() throws Exception {

		setCaption("Vaadin Meetups");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		List<Group> allVaadinMeetups;
			allVaadinMeetups = MeetupsService.getAllVaadinMeetups();
			for (Group meetupGroup : allVaadinMeetups) {
				Embedded photo;
				if (meetupGroup.getPhotoUrl() == null
						|| meetupGroup.getPhotoUrl().isEmpty()) {

					photo = new Embedded(null, new ThemeResource(MEETUP_ICON));
				} else {
					photo = new Embedded(null, new ExternalResource(
							meetupGroup.getPhotoUrl()));
				}
				photo.setWidth("50px");
				photo.setHeight("50px");
				RowOfData rowOfData = new RowOfData(photo, new Label(
						meetupGroup.getName()), meetupGroup);
				rowOfData.addLayoutClickListener(new LayoutClickListener() {

					@Override
					public void layoutClick(LayoutClickEvent event) {
						getNavigationManager().navigateTo(
								new MeetupInfoView((Group) ((RowOfData) event
										.getComponent()).getObject()));

					}
				});
				content.addComponent(rowOfData);
			}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}
}
