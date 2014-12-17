package org.vaadin.tunis.VaadinCommunityApp.ui;

import java.util.List;

import org.vaadin.tunis.VaadinCommunityApp.services.rss.FeedEntry;
import org.vaadin.tunis.VaadinCommunityApp.services.rss.RomeRssReader;
import org.vaadin.tunis.VaadinCommunityApp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class BlogsView extends NavigationView {
	private static String rssUrl = "http://vaadin.com/blog/-/blogs/rss?_33_max=10";
	static String blogIcon = "../../icons/blog.png";

	public BlogsView() {
		setCaption("Blogs");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		List<FeedEntry> feedVaadinNews = RomeRssReader.getItems(rssUrl);
		for (FeedEntry feedEntry : feedVaadinNews) {

			Embedded photo = new Embedded(null, new ThemeResource(blogIcon));
			RowOfData rowOfData = new RowOfData(photo, new Label(
					feedEntry.getTitle()), feedEntry);
			photo.setWidth("50px");
			photo.setHeight("50px");
			photo.addStyleName("circular");

			content.addComponent(rowOfData);
		}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}

}
