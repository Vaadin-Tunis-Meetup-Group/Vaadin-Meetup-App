package org.vaadin.tunis.VaadinCommunityApp.ui;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.ui.UI;

public class HomeUIBuilder {
	NavigationManager homeNavigationManager = new NavigationManager();

	public static void initHomeScreen(UI home) {
		home.setContent(getHomeComponent());
	}

	private static NavigationView getHomeComponent() {

		return new HomeView();
	}

}
