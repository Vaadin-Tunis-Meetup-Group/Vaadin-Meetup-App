package org.vaadin.tunis.vaadincommunityapp.ui;

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

@SuppressWarnings("serial")
public class AddonsView extends NavigationView {
	private static String rssUrl = "http://vaadin.com/directory/-/directory/rss/recent";

	public AddonsView() throws Exception{
		setCaption("Addons");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		List<FeedEntry> feedVaadinNews = RomeRssReader.getItems(rssUrl);
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
							((FeedEntry) ((RowOfData) event.getComponent())
									.getObject()).getLink(), "_blank");

				}
			});
		}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}
}
