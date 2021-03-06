package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.services.rss.FeedEntry;
import org.vaadin.tunis.vaadincommunityapp.services.rss.RomeRssReader;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@SuppressWarnings("serial")
public class AddonsView extends NavigationView {
	private static String rssUrl = "http://vaadin.com/directory/-/directory/rss/recent";
	final VerticalComponentGroup content = new VerticalComponentGroup();
	List<FeedEntry> feedVaadinNews = new ArrayList<FeedEntry>();

	@Override
	public void attach() {
		loadRssAddons();
		super.attach();
	}

	private void loadRssAddons() {
		if (feedVaadinNews.isEmpty()) {
			try {

				feedVaadinNews = RomeRssReader.getItems(rssUrl);
				for (FeedEntry feedEntry : feedVaadinNews) {
					Label label = new Label();
					label.setContentMode(ContentMode.HTML);
					StringBuilder value = new StringBuilder();
					value.append("<div style='color:#000000;'>");
					value.append(FontAwesome.PUZZLE_PIECE.getHtml());
					value.append(" <b>");
					value.append(feedEntry.getTitle());
					value.append("</b></div>");
					value.append("<font size='-1'>");
					value.append("By ");
					value.append("<font color='#00b4f0'>");
					value.append(feedEntry.getAuthor());
					value.append("</font></font>");
					value.append("<div><font size='-2' color='gray'>");
					value.append(feedEntry.getDescription());
					value.append("</font></div>");
					label.setValue(value.toString());

					RowOfData rowOfData = new RowOfData(label, feedEntry);
					content.addComponent(rowOfData);
					rowOfData.addLayoutClickListener(new LayoutClickListener() {

						@Override
						public void layoutClick(LayoutClickEvent event) {
							getUI().getPage().open(
									((FeedEntry) ((RowOfData) event
											.getComponent()).getObject())
											.getLink(), "_blank");

						}
					});
				}
			} catch (Exception e) {
				Notification.show(
						"Service unavailable, Please try again later",
						Type.WARNING_MESSAGE);
			}
		}
	}

	public AddonsView() {
		setCaption("Addons");

		content.setSizeFull();

		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}
}
