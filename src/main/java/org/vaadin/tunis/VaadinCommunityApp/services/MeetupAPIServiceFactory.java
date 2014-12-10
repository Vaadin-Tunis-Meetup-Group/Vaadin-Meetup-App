package org.vaadin.tunis.VaadinCommunityApp.services;

import meetup.ClientSettings;
import meetup.MeetupClient;

public class MeetupAPIServiceFactory {

	private static MeetupAPIServiceFactory instance = null;
	private static ClientSettings settings;
	private static MeetupClient meetupClient;

	private static String API_KEY = "1ec7f3873471e53377e594d35246a5f";

	private MeetupAPIServiceFactory() {
		settings = new ClientSettings();
		settings.setMeetupKey(API_KEY);
		meetupClient = new MeetupClient();
		meetupClient.setClientSettings(settings);
	}

	public static MeetupAPIServiceFactory getInstance() {
		if (instance == null)
			instance = new MeetupAPIServiceFactory();
		return instance;
	}

	public MeetupClient getMeetupClient() {
		return meetupClient;
	}

}
