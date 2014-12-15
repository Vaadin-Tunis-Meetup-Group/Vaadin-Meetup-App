package org.vaadin.tunis.VaadinCommunityApp.services.meetupapi;

import java.util.List;

import meetup.Group;
import meetup.GroupSearchCriteria;

public class MeetupsService {
	private static String TOPIC = "Vaadin";
	private static MeetupAPIServiceFactory meetupApiService = MeetupAPIServiceFactory
			.getInstance();

	public static List<Group> getAllVaadinMeetups() {
		GroupSearchCriteria groupSearchCriteria = new GroupSearchCriteria();
		groupSearchCriteria.setTopic(TOPIC);
		return meetupApiService.getMeetupClient().getGroups(groupSearchCriteria);

	}
	
	public static void main(String[] args) {
		List<Group> allVaadinMeetups = getAllVaadinMeetups();
		System.out.println(allVaadinMeetups.size());
	}
}
