package org.vaadin.tunis.VaadinCommunityApp;

import java.util.List;

import meetup.ClientSettings;
import meetup.MeetupClient;
import meetup.Member;
import meetup.MemberSearchCriteria;

import org.vaadin.tunis.VaadinCommunityApp.gwt.client.VaadinCommunityAppPersistToServerRpc;
import org.vaadin.tunis.VaadinCommunityApp.ui.FormView;
import org.vaadin.tunis.VaadinCommunityApp.ui.MeetupsView;
import org.vaadin.tunis.VaadinCommunityApp.ui.MembersView;
import org.vaadin.tunis.VaadinCommunityApp.ui.MenuView;

import com.vaadin.addon.touchkit.annotations.CacheManifestEnabled;
import com.vaadin.addon.touchkit.annotations.OfflineModeEnabled;
import com.vaadin.addon.touchkit.extensions.OfflineMode;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

/**
 * The UI's "main" class
 */
@SuppressWarnings("serial")
@Widgetset("org.vaadin.tunis.VaadinCommunityApp.gwt.VaadinCommunityAppWidgetSet")
@Theme("touchkit")
// Cache static application files so as the application can be started
// and run even when the network is down.
@CacheManifestEnabled
// Switch to the OfflineMode client UI when the server is unreachable
@OfflineModeEnabled
// Make the server retain UI state whenever the browser reloads the app
@PreserveOnRefresh
public class VaadinCommunityAppTouchKitUI extends UI {

	private final VaadinCommunityAppPersistToServerRpc serverRpc = new VaadinCommunityAppPersistToServerRpc() {
		@Override
		public void persistToServer() {
			// TODO this method is called from client side to store offline data
		}
	};

	@Override
	protected void init(VaadinRequest request) {
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
		
		
		
		
		setContent(tabBarView);

		// Use of the OfflineMode connector is optional.
		OfflineMode offlineMode = new OfflineMode();
		offlineMode.extend(this);
		// Maintain the session when the browser app closes.
		offlineMode.setPersistentSessionCookie(true);
		// Define the timeout in secs to wait when a server request is sent
		// before falling back to offline mode.
		offlineMode.setOfflineModeTimeout(15);
	}
}
