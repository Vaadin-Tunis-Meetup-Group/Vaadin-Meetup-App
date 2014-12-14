package org.vaadin.tunis.VaadinCommunityApp.ui;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.UI;
import com.vaadin.ui.TabSheet.Tab;

public class HomeUIBuilder {

	public static void initHomeScreen(UI home){
		home.setContent(getHomeComponent());
	}

	private static TabBarView getHomeComponent() {
		
		final TabBarView tabBarView = new TabBarView();
		final NavigationManager newsNavigationManager = new NavigationManager();
		final NavigationManager eventsNavigationManager = new NavigationManager();
		final NavigationManager addonsNavigationManager = new NavigationManager();
		final NavigationManager meetupsNavigationManager = new NavigationManager();
		final NavigationManager othersNavigationManager = new NavigationManager();

		newsNavigationManager.setCaption("News");
		eventsNavigationManager.setCaption("Events");
		addonsNavigationManager.setCaption("Add-Ons");

		meetupsNavigationManager.setCaption("Meetups");
		meetupsNavigationManager.setCurrentComponent(new MeetupsView());

		othersNavigationManager.setCaption("More");

		Tab tab;
		tab = tabBarView.addTab(newsNavigationManager);
		tab.setIcon(FontAwesome.RSS);

		tab = tabBarView.addTab(eventsNavigationManager);
		tab.setIcon(FontAwesome.CALENDAR);

		tab = tabBarView.addTab(addonsNavigationManager);
		tab.setIcon(FontAwesome.DOWNLOAD);

		tab = tabBarView.addTab(meetupsNavigationManager);
		tab.setIcon(FontAwesome.GROUP);

		tab = tabBarView.addTab(othersNavigationManager);
		tab.setIcon(FontAwesome.FLICKR);
		return tabBarView;
	}
}
