package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.services.DateUtil;
import org.vaadin.tunis.vaadincommunityapp.services.rss.FeedEntry;
import org.vaadin.tunis.vaadincommunityapp.services.rss.RomeRssReader;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class BlogsView extends NavigationView {
	private static String rssUrl = "http://vaadin.com/blog/-/blogs/rss?_33_max=10";

	public BlogsView() throws Exception{
		setCaption("Blogs");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		try {
			List<FeedEntry> feedVaadinNews = RomeRssReader.getItems(rssUrl);
			for (FeedEntry feedEntry : feedVaadinNews) {
				Label label = new Label();
				label.setContentMode(ContentMode.HTML);
				StringBuilder value = new StringBuilder();
				value.append("<div style='color:#00b4f0;'>");
				value.append(FontAwesome.ARROW_RIGHT.getHtml());
				value.append(" <b>");
				value.append(feedEntry.getTitle());
				value.append("</b></div><Br>");
				value.append("By ");
				value.append("<font color='#00b4f0'>");
				value.append(feedEntry.getAuthor());
				value.append("</font>");
				value.append(", | ");
				value.append("<font size='-1' color='gray'>");
				value.append("On ");
				value.append(DateUtil.formatDate(feedEntry.getPubDate(),
						"dd/M/yyyy"));
				value.append("</font>");
				label.setValue(value.toString());

				Link link = new Link("Read more", new ExternalResource(
						feedEntry.getLink()));
				link.setTargetName("_blank");
				link.setIcon(FontAwesome.ANGLE_DOUBLE_RIGHT);
				link.addStyleName("icon-after-caption");

				VerticalLayout layout = new VerticalLayout();
				layout.addComponent(label);
				layout.addComponent(link);
				layout.setExpandRatio(label, 1f);
				layout.setSpacing(true);
				layout.setSizeFull();

				RowOfData rowOfData = new RowOfData(layout, feedEntry);
				content.addComponent(rowOfData);
			}
		} catch (NullPointerException e) {
			Notification.show("Please check your internet connection",
					Type.WARNING_MESSAGE);
		}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
		((HomeView)getNavigationManager().getParent()).blogsButton.setEnabled(true);
	}
}
