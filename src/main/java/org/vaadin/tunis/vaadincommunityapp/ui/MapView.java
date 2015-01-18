package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.LeafletClickEvent;
import org.vaadin.addon.leaflet.LeafletClickListener;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.tunis.vaadincommunityapp.VaadinCommunityAppTouchKitUI;
import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.services.meetupapi.MeetupsService;

import com.vaadin.addon.touchkit.extensions.Geolocator;
import com.vaadin.addon.touchkit.extensions.PositionCallback;
import com.vaadin.addon.touchkit.gwt.client.vcom.Position;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@SuppressWarnings("serial")
public class MapView extends CssLayout implements PositionCallback,
		LeafletClickListener {

	private LMap map;
	private Button locatebutton;
	private LMarker you;
	private List<Group> allVaadinMeetups;

	@Override
	public void attach() {
		if (map == null) {
			buildView();
			Geolocator.detect(MapView.this);
		}
		updateMarkers();
		setCenter();
		super.attach();
	};

	private void buildView() {
		setCaption("Map");
		addStyleName("mapview");
		setSizeFull();

		map = new LMap();

		// Note, if you wish to use Mapbox base maps, get your own API key.
		LTileLayer mapBoxTiles = new LTileLayer(
				"http://{s}.tile.osm.org/{z}/{x}/{y}.png");
		mapBoxTiles.setDetectRetina(true);
		map.addLayer(mapBoxTiles);

		map.setAttributionPrefix("Powered by <a href=\"https://github.com/Vaadin-Tunis-Meetup-Group/\">Vaadin Tunis</a> — &copy; <a href='http://vaadin.com/meetup'>Vaadin</a> meetups");

		map.setImmediate(true);

		map.setSizeFull();
		map.setZoomLevel(3);
		addComponent(map);

		locatebutton = new Button("", new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				Geolocator.detect(MapView.this);
			}
		});
		locatebutton.addStyleName("locatebutton");
		locatebutton.setIcon(FontAwesome.LOCATION_ARROW);
		locatebutton.setDisableOnClick(true);
		addComponent(locatebutton);
	}

	public final void updateMarkers() {
		try {
			allVaadinMeetups = MeetupsService.getAllVaadinMeetups();
			Iterator<Component> iterator = map.iterator();
			Collection<Component> remove = new ArrayList<Component>();
			while (iterator.hasNext()) {
				Component next = iterator.next();
				if (next instanceof LMarker) {
					remove.add(next);
				}
			}
			for (Component component : remove) {
				map.removeComponent(component);
			}

			for (Group meetup : allVaadinMeetups) {
				LMarker leafletMarker = new LMarker(Double.parseDouble(meetup
						.getLatitude()), Double.parseDouble(meetup
						.getLongitude()));
				leafletMarker.setIcon(new ThemeResource("icons/pin.png"));
				leafletMarker.setIconSize(new Point(24, 38));
				leafletMarker.setIconAnchor(new Point(11, 38));
				leafletMarker.setTitle(meetup.getName());
				leafletMarker.setPopup(meetup.getName());
				map.addComponent(leafletMarker);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSuccess(Position position) {
		VaadinCommunityAppTouchKitUI app = VaadinCommunityAppTouchKitUI
				.getApp();
		app.setCurrentLatitude(position.getLatitude());
		app.setCurrentLongitude(position.getLongitude());
		you = new LMarker();
		you.setPoint(new Point(VaadinCommunityAppTouchKitUI.getApp()
				.getCurrentLatitude(), VaadinCommunityAppTouchKitUI.getApp()
				.getCurrentLongitude()));
		if (you.getParent() == null) {
			map.addComponent(you);
		}
		setCenter();
		locatebutton.setEnabled(true);
	}

	private void setCenter() {
		if (map != null & you != null) {
			map.setCenter(you.getPoint());
		}
	}

	@Override
	public void onFailure(final int errorCode) {
		Notification
				.show("Geolocation request failed. You must grant access for geolocation requests.",
						Type.ERROR_MESSAGE);
		locatebutton.setEnabled(true);
	}

	@Override
	public void onClick(LeafletClickEvent event) {

	}

	public List<Group> getAllVaadinMeetups() {
		return allVaadinMeetups;
	}

	public void setAllVaadinMeetups(List<Group> allVaadinMeetups) {
		this.allVaadinMeetups = allVaadinMeetups;
	}

}
