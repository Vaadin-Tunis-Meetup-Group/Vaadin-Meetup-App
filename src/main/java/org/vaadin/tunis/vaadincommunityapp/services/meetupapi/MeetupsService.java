package org.vaadin.tunis.vaadincommunityapp.services.meetupapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.model.Events;
import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.model.Member;
import org.vaadin.tunis.vaadincommunityapp.model.Photo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MeetupsService {
	// private static String TOPIC = "Vaadin";
	// private static MeetupAPIServiceFactory MEETUP_API_SERVICE =
	// MeetupAPIServiceFactory
	// .getInstance();

	private MeetupsService() {
		// fix sonar violation
	}

	public static List<Group> getAllVaadinMeetups() throws Exception {
		String url = "https://api.meetup.com/2/groups?&sign=true&photo-host=public&topic=vaadin&key=1ec7f3873471e53377e594d35246a5f";
		JsonObject jsonResponse = readJsonFromUrl(url);
		JsonArray asJsonArray = jsonResponse.get("results").getAsJsonArray();
		List<Group> groups = new ArrayList<Group>();
		for (JsonElement object : asJsonArray) {
			Group group = new Group();
			group.setName(object.getAsJsonObject().get("name").getAsString());
			group.setGroupUrlName(object.getAsJsonObject().get("urlname")
					.getAsString());
			JsonElement photoElement = object.getAsJsonObject().get(
					"group_photo");
			if (photoElement != null) {
				group.setPhotoUrl(photoElement.getAsJsonObject()
						.get("photo_link").getAsString());
			}
			group.setDescription(object.getAsJsonObject().get("description")
					.getAsString());
			group.setLatitude(object.getAsJsonObject().get("lat").getAsString());
			group.setLongitude(object.getAsJsonObject().get("lon").getAsString());
			groups.add(group);
		}
		return groups;

	}

	public static List<Events> getPassedEvents(String groupUrlName) {
		try {
			String url = "https://api.meetup.com/2/events?&sign=true&status=past&photo-host=public&group_urlname="
					+ groupUrlName.toLowerCase()
					+ "&page=100&key=1ec7f3873471e53377e594d35246a5f";
			JsonObject jsonResponse = readJsonFromUrl(url);
			List<Events> meetupEvents = new ArrayList<Events>();

			JsonArray jsonArray = jsonResponse.get("results").getAsJsonArray();

			for (JsonElement element : jsonArray) {
				Events events = new Events();
				events.setDescription(element.getAsJsonObject()
						.get("description").getAsString());
				events.setName(element.getAsJsonObject().get("name")
						.getAsString());
				events.setTime(new Date(Long.parseLong(element
						.getAsJsonObject().get("time").getAsString())));
				events.setRsvpCount(Integer.parseInt(element.getAsJsonObject()
						.get("yes_rsvp_count").getAsString()));
				meetupEvents.add(events);
			}

			return meetupEvents;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Events>();
	}

	public static List<Events> getUpcomingEvents(String groupUrlName) {
		try {
			String url = "https://api.meetup.com/2/events?&sign=true&status=upcoming&photo-host=public&group_urlname="
					+ groupUrlName.toLowerCase()
					+ "&page=30&key=1ec7f3873471e53377e594d35246a5f";
			JsonObject jsonResponse = readJsonFromUrl(url);
			List<Events> meetupEvents = new ArrayList<Events>();

			JsonArray jsonArray = jsonResponse.get("results").getAsJsonArray();

			for (JsonElement element : jsonArray) {
				Events events = new Events();
				events.setDescription(element.getAsJsonObject()
						.get("description").getAsString());
				events.setName(element.getAsJsonObject().get("name")
						.getAsString());
				events.setTime(new Date(Long.parseLong(element
						.getAsJsonObject().get("time").getAsString())));
				events.setRsvpCount(Integer.parseInt(element.getAsJsonObject()
						.get("yes_rsvp_count").getAsString()));
				meetupEvents.add(events);
			}

			return meetupEvents;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Events>();
	}

	public static List<Photo> getMeetupPhotos(String groupUrlName) {
		try {
			String url = "https://api.meetup.com/2/photos?&sign=true&photo-host=public&group_urlname="
					+ groupUrlName.toLowerCase()
					+ "&key=1ec7f3873471e53377e594d35246a5f";
			JsonObject jsonResponse = readJsonFromUrl(url);
			JsonArray asJsonArray = jsonResponse.get("results")
					.getAsJsonArray();
			List<Photo> photos = new ArrayList<Photo>();
			for (JsonElement element : asJsonArray) {
				Photo photo = new Photo();
				photo.setMemberName(((JsonObject) element.getAsJsonObject()
						.get("member")).get("name").getAsString());
				photo.setPhotoLink(element.getAsJsonObject().get("photo_link")
						.getAsString());
				photo.setThumbLink(element.getAsJsonObject().get("thumb_link")
						.getAsString());
				photo.setHighresLink(element.getAsJsonObject()
						.get("highres_link").getAsString());
				photos.add(photo);
			}
			return photos;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Photo>();

	}

	public static List<Member> getMeetupMembers(String groupUrlName) {
		try {
			String url = "https://api.meetup.com/2/members?&sign=true&photo-host=public&group_urlname="
					+ groupUrlName.toLowerCase()
					+ "&key=1ec7f3873471e53377e594d35246a5f";
			JsonObject jsonResponse = readJsonFromUrl(url);
			JsonArray asJsonArray = jsonResponse.get("results")
					.getAsJsonArray();
			List<Member> members = new ArrayList<Member>();
			for (JsonElement object : asJsonArray) {
				Member member = new Member();
				member.setName(object.getAsJsonObject().get("name")
						.getAsString());

				JsonElement photoElement = object.getAsJsonObject()
						.get("photo");
				if (photoElement != null) {
					member.setPhotoUrl(photoElement.getAsJsonObject()
							.get("photo_link").getAsString());
				}
				members.add(member);
			}
			return members;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ArrayList<Member>();
	}

	/* JSON utility method */
	private static JsonObject readJsonFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JsonElement jelement = new JsonParser().parse(jsonText);
			JsonObject jobject = jelement.getAsJsonObject();
			return jobject;
		} finally {
			is.close();
		}
	}

	/* JSON utility method */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}
