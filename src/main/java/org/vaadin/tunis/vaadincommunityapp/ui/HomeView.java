package org.vaadin.tunis.vaadincommunityapp.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;

@SuppressWarnings("serial")
public class HomeView extends NavigationView {
	private MapView mapView;

	public HomeView() {
		setCaption("Home");
		setMapView(new MapView());
		setContent(getMapView());
	}

	public MapView getMapView() {
		return mapView;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
}
