package org.vaadin.tunis.vaadincommunityapp.services.rss;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RomeRssReader {
	private static final Logger LOGGER = Logger.getLogger(RomeRssReader.class
			.getName());

	private RomeRssReader() {
		//fix sonar violation
	}

	public static List<FeedEntry> getItems(String rssUrl) {
		List<FeedEntry> items = new ArrayList<FeedEntry>();
		SyndFeed feed = getFeedFromURL(rssUrl);
		Iterator<?> iter = feed.getEntries().iterator();
		while (iter.hasNext()) {
			SyndEntry entry = (SyndEntry) iter.next();
			FeedEntry item = transformToFeedEntry(entry);
			items.add(item);
		}
		return items;
	}

	private static FeedEntry transformToFeedEntry(SyndEntry entry) {
		FeedEntry feedEntry = new FeedEntry();

		feedEntry.setTitle(entry.getTitle());
		feedEntry.setPubDate(entry.getPublishedDate());
		feedEntry.setDescription(entry.getDescription().getValue());
		feedEntry.setAuthor(entry.getAuthor());
		feedEntry.setLink(entry.getLink());
		return feedEntry;
	}

	public static SyndFeed getFeedFromURL(String rssUrl) {
		SyndFeed feed = null;
		XmlReader xmlReader = null;
		SyndFeedInput input = new SyndFeedInput();
		try {
			xmlReader = new XmlReader(new URL(rssUrl));
			feed = input.build(xmlReader);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			if (xmlReader != null) {
				try {
					xmlReader.close();
				} catch (IOException e) {
					LOGGER.error(e);
				}
			}
		}

		return feed;
	}

}
