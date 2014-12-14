package org.vaadin.tunis.VaadinCommunityApp.ui;

import meetup.Group;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class MeetupInfoView extends NavigationView {

	Toolbar toolbar = new Toolbar();
	Group meetup;

	public MeetupInfoView(Group meetup) {
		this.meetup = meetup;
		setSizeFull();
		setCaption(meetup.getName());
		initToolbar();
		setToolbar(toolbar);
	}

	private void initToolbar() {
		Button homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		toolbar.addComponent(homeButton);

		Button calendarButton = new Button("Calendar");
		calendarButton.setIcon(FontAwesome.CALENDAR);
		toolbar.addComponent(calendarButton);

		Button photoButton = new Button("Photo");
		photoButton.setIcon(FontAwesome.PHOTO);
		toolbar.addComponent(photoButton);

		Button membersButtons = new Button("Members");
		membersButtons.setIcon(FontAwesome.GROUP);
		membersButtons.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(
						new MembersView(meetup.getGroupUrlName()));

			}
		});

		toolbar.addComponent(membersButtons);

	}
}
