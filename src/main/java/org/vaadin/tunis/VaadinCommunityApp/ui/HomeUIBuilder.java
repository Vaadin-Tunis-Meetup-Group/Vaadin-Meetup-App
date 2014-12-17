package org.vaadin.tunis.VaadinCommunityApp.ui;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.ui.UI;

public class HomeUIBuilder {
	

	public static void initHomeScreen(UI home) {
		NavigationManager homeNavigationManager = new NavigationManager();
		homeNavigationManager.setCurrentComponent(getHomeComponent());
		home.setContent(homeNavigationManager);
	}

	private static NavigationView getHomeComponent() {
		
		return new HomeView();
	}

}
