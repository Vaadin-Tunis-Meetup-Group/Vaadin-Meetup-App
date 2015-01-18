package org.vaadin.tunis.vaadincommunityapp;

import org.vaadin.tunis.vaadincommunityapp.gwt.client.VaadinCommunityAppPersistToServerRpc;
import org.vaadin.tunis.vaadincommunityapp.ui.HomeUIBuilder;

import com.vaadin.addon.touchkit.annotations.CacheManifestEnabled;
import com.vaadin.addon.touchkit.annotations.OfflineModeEnabled;
import com.vaadin.addon.touchkit.extensions.OfflineMode;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * The UI's "main" class
 */
@SuppressWarnings("serial")
@Widgetset("org.vaadin.tunis.vaadincommunityapp.gwt.VaadinCommunityAppWidgetSet")
@Theme("VCApp")
// Cache static application files so as the application can be started
// and run even when the network is down.
@CacheManifestEnabled
// Switch to the OfflineMode client UI when the server is unreachable
@OfflineModeEnabled
// Make the server retain UI state whenever the browser reloads the app
@PreserveOnRefresh
public class VaadinCommunityAppTouchKitUI extends UI {

	private static final int OFFLINE_MODE_TIMEOUT = 60;
	private double currentLatitude = 60.452541;

	private double currentLongitude = 22.30083;

	private final VaadinCommunityAppPersistToServerRpc serverRpc = new VaadinCommunityAppPersistToServerRpc() {
		@Override
		public void persistToServer() {
			// TODO this method is called from client side to store offline data
		}
	};

	@Override
	protected void init(VaadinRequest request) {

		HomeUIBuilder.initHomeScreen(this);

		// Use of the OfflineMode connector is optional.
		OfflineMode offlineMode = new OfflineMode();
		offlineMode.extend(this);
		// Maintain the session when the browser app closes.
		offlineMode.setPersistentSessionCookie(true);
		// Define the timeout in secs to wait when a server request is sent
		// before falling back to offline mode.
		offlineMode.setOfflineModeTimeout(OFFLINE_MODE_TIMEOUT);
	}

	public static VaadinCommunityAppTouchKitUI getApp() {
		return (VaadinCommunityAppTouchKitUI) UI.getCurrent();
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}
}
