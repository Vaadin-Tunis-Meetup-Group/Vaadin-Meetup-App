package org.vaadin.tunis.VaadinCommunityApp.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
