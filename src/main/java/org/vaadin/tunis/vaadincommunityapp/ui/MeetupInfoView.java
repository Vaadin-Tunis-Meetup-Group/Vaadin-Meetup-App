package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.model.Events;
import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.model.Member;
import org.vaadin.tunis.vaadincommunityapp.services.meetupapi.MeetupsService;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

@SuppressWarnings("serial")
public class MeetupInfoView extends NavigationView {
	private static String MEETUP_ICON = "icons/meetup-icon.png";
	private static String passedEventContent = "Passed events";
	private static String membersContent = "Members";
	private static String incomingEventContent = "Incoming Events";
	int passedEventNbr = -1;

	Toolbar toolbar = new Toolbar();
	Group meetupGroup;
	List<Member> meetupMembers = new ArrayList<Member>();
	List<Events> meetupPassedEvents = new ArrayList<Events>();
	List<Events> meetupUpCommingEvents = new ArrayList<Events>();
	final VerticalComponentGroup content = new VerticalComponentGroup();
	final TabSheet tabSheet = new TabSheet();

	public MeetupInfoView(Group meetup) {
		this.meetupGroup = meetup;
		setSizeFull();
		setCaption(meetup.getName());
		setContent(tabSheet);
		initBody();
	}

	private void initBody() {
		tabSheet.setSizeFull();
		tabSheet.addStyleName("material-design");
		content.setSizeFull();
		AbsoluteLayout headerLayout = initHeaderLayout();

		HorizontalLayout headerInfoLayout = initHeaderInfoLayout();

		Label bodyLayout = initBodyLayout();

		content.addComponent(headerLayout);
		content.addComponent(headerInfoLayout);
		content.addComponent(bodyLayout);
		content.setHeightUndefined();
		Tab tab;
		tab = tabSheet.addTab(content, "Info", FontAwesome.INFO_CIRCLE);
		tab = tabSheet.addTab(new MeetupPhotosView(meetupGroup), "Photos",
				FontAwesome.PHOTO);
	}

	/**
	 * @return
	 */
	private Label initBodyLayout() {

		Label meetupDescription = new Label();
		meetupDescription.setContentMode(ContentMode.HTML);
		meetupDescription.setValue(meetupGroup.getDescription());

		return meetupDescription;
	}

	/**
	 * @return
	 */
	private HorizontalLayout initHeaderInfoLayout() {
		HorizontalLayout headerInfoLayout = new HorizontalLayout();

		Button passedEvent = new Button();
		passedEvent.setHtmlContentAllowed(true);
		passedEvent.setCaption(FontAwesome.CALENDAR_O.getHtml() + "<br>" + getPassedEvents());
		passedEvent.setHeight("60px");
		passedEvent.addStyleName("material-design");
		// passedEvent.addStyleName("v-button-blue");

		Button membersNumber = new Button();
		membersNumber.setHtmlContentAllowed(true);
		membersNumber.setCaption(FontAwesome.USER.getHtml() + "<br>" + getMeetupMember());
		membersNumber.setHeight("60px");
		membersNumber.addStyleName("material-design");
		// membersNumber.addStyleName("v-button-green");

		Button incomingEvent = new Button();
		incomingEvent.setHtmlContentAllowed(true);
		incomingEvent.setCaption(FontAwesome.CALENDAR.getHtml() + "<br>"
				+ getUpcomingEvents());
		incomingEvent.setHeight("60px");
		incomingEvent.addStyleName("material-design");
		// incomingEvent.addStyleName("v-button-purple");

		passedEvent.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (meetupPassedEvents.isEmpty()) {
					Notification.show(
							"No passed events for " + meetupGroup.getName(),
							Type.WARNING_MESSAGE);
				} else {
					getNavigationManager()
							.navigateTo(
									new MeetupEventView(meetupPassedEvents,
											meetupGroup));
				}
			}
		});
		membersNumber.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(
						new MembersView(meetupMembers));
			}
		});

		incomingEvent.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (meetupUpCommingEvents.isEmpty()) {
					Notification.show(
							"No upcoming events for " + meetupGroup.getName(),
							Type.WARNING_MESSAGE);
				} else {
					getNavigationManager().navigateTo(
							new MeetupEventView(meetupUpCommingEvents,
									meetupGroup));
				}
			}
		});

		headerInfoLayout.addComponent(passedEvent);
		headerInfoLayout.addComponent(membersNumber);
		headerInfoLayout.addComponent(incomingEvent);

		headerInfoLayout.setExpandRatio(passedEvent, 1.0f);
		headerInfoLayout.setExpandRatio(membersNumber, 1.0f);
		headerInfoLayout.setExpandRatio(incomingEvent, 1.0f);

		headerInfoLayout.setWidth("100%");
		headerInfoLayout.setHeight("65px");
		headerInfoLayout.setSpacing(false);

		return headerInfoLayout;
	}

	private int getMeetupMember() {
		if (meetupMembers.isEmpty()) {
			meetupMembers = MeetupsService.getMeetupMembers(meetupGroup
					.getGroupUrlName());
		}
		return meetupMembers.size();
	}

	private int getUpcomingEvents() {
		if (meetupUpCommingEvents.isEmpty()) {
			meetupUpCommingEvents = MeetupsService
					.getUpcomingEvents(meetupGroup.getGroupUrlName());
		}
		return meetupUpCommingEvents.size();
	}

	/**
	 * 
	 */
	private int getPassedEvents() {
		if (meetupPassedEvents.isEmpty()) {
			meetupPassedEvents = MeetupsService.getPassedEvents(meetupGroup
					.getGroupUrlName());
		}
		return meetupPassedEvents.size();
	}

	/**
	 * @return
	 */
	private AbsoluteLayout initHeaderLayout() {
		AbsoluteLayout headerLayout = new AbsoluteLayout();
		headerLayout.setWidth("100%");
		headerLayout.setHeight("200px");
		Embedded photo;
		if (meetupGroup.getPhotoUrl() == null
				|| meetupGroup.getPhotoUrl().isEmpty()) {

			photo = new Embedded(null, new ThemeResource(MEETUP_ICON));
		} else {
			photo = new Embedded(null, new ExternalResource(
					meetupGroup.getPhotoUrl()));
		}
		photo.setHeight("100px");
		headerLayout.addComponent(photo, "left: 40%; right: 40%;"
				+ "top: 15%; bottom: 15%;");
		return headerLayout;
	}

	private void initToolbar() {
		Button homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		toolbar.addComponent(homeButton);

		Button calendarButton = new Button("Calendar");
		calendarButton.setIcon(FontAwesome.CALENDAR);
		calendarButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (meetupUpCommingEvents.isEmpty()) {
					Notification.show(
							"No upcoming events for " + meetupGroup.getName(),
							Type.WARNING_MESSAGE);
				} else {
					getNavigationManager().navigateTo(
							new MeetupEventView(meetupUpCommingEvents,
									meetupGroup));
				}
			}
		});
		toolbar.addComponent(calendarButton);

		Button photoButton = new Button("Photo");
		photoButton.setIcon(FontAwesome.PHOTO);
		photoButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(
						new MeetupPhotosView(meetupGroup));

			}
		});
		toolbar.addComponent(photoButton);

		Button membersButtons = new Button("Members");
		membersButtons.setIcon(FontAwesome.GROUP);
		membersButtons.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(
						new MembersView(meetupMembers));

			}
		});

		toolbar.addComponent(membersButtons);

	}
}
