package org.vaadin.tunis.vaadincommunityapp.services.google.calendar;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.common.io.Files;

public class GoogleCalendarAPIServiceFactory {

	private static GoogleCalendarAPIServiceFactory instance = null;
	public Calendar service = null;
	private static String CREDENTIAL_FILE = "API-Project.p12";

	/**
	 * Be sure to specify the name of your application. If the application name
	 * is {@code null} or blank, the application will log a warning. Suggested
	 * format is "MyCompany-ProductName/1.0".
	 */
	private static final String APPLICATION_NAME = "ServiceCalendar";

	/** E-mail address of the service account. */
	private static final String SERVICE_ACCOUNT_EMAIL = "430023006562-g2f6jqr2879dgf559h3i0kqk54ki1gp7@developer.gserviceaccount.com";

	/** Global instance of the HTTP transport. */
	private static HttpTransport httpTransport;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();

	private GoogleCalendarAPIServiceFactory() {

	}

	public static GoogleCalendarAPIServiceFactory getInstance() {

		if (instance == null) {
			instance = new GoogleCalendarAPIServiceFactory();
			instance.service = GoogleCalendarAPIServiceFactory.configure();
		}
		return instance;
	}

	private static Calendar configure() {
		try {
			try {
				httpTransport = new NetHttpTransport();
				// check for valid setup
				if (SERVICE_ACCOUNT_EMAIL.startsWith("Enter ")) {
					System.err.println(SERVICE_ACCOUNT_EMAIL);
					System.exit(1);
				}

				File file = new File(
						"src/main/webapp/VAADIN/google/calendar/"
								+ CREDENTIAL_FILE);
				String p12Content = Files.readFirstLine(file,
						Charset.defaultCharset());
				if (p12Content.startsWith("Please")) {
					System.err.println(p12Content);
					System.exit(1);
				}
				// service account credential (uncomment setServiceAccountUser
				// for domain-wide delegation)
				GoogleCredential credential = new GoogleCredential.Builder()
						.setTransport(httpTransport)
						.setJsonFactory(JSON_FACTORY)
						.setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
						.setServiceAccountScopes(
								Collections.singleton(CalendarScopes.CALENDAR))
						.setServiceAccountPrivateKeyFromP12File(file).build();
				Calendar client = new com.google.api.services.calendar.Calendar.Builder(
						httpTransport, JSON_FACTORY, credential)
						.setApplicationName(APPLICATION_NAME).build();
				System.out.println("Client : " + client);
				return client;

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(1);
		return null;
	}
}
