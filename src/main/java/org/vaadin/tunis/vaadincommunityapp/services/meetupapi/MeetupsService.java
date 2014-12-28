package org.vaadin.tunis.vaadincommunityapp.services.meetupapi;

import java.util.List;

import meetup.Group;
import meetup.GroupSearchCriteria;

public class MeetupsService {
	private static String TOPIC = "Vaadin";
	private static MeetupAPIServiceFactory MEETUP_API_SERVICE = MeetupAPIServiceFactory
			.getInstance();

	private MeetupsService() {
		// fix sonar violation
	}

	public static List<Group> getAllVaadinMeetups() {
		GroupSearchCriteria groupSearchCriteria = new GroupSearchCriteria();
		groupSearchCriteria.setTopic(TOPIC);
		return MEETUP_API_SERVICE.getMeetupClient().getGroups(
				groupSearchCriteria);

	}
}
