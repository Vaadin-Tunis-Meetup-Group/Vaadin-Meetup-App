package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.services.meetupapi.MeetupsService;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.RowOfData;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@SuppressWarnings("serial")
public class MeetupsView extends NavigationView {
	private static String MEETUP_ICON = "icons/meetup-icon.png";
	final VerticalComponentGroup content = new VerticalComponentGroup();
	List<Group> allVaadinMeetups = new ArrayList<Group>();
	private HomeView homeView;
	private boolean rendred = false;

	@Override
	public void attach() {
		if (!rendred) {
			createMeetupsView();
			rendred = true;
		}
		super.attach();
	}

	private void createMeetupsView() {

		if (homeView != null) {
			allVaadinMeetups = homeView.getMapView().getAllVaadinMeetups();
		}
		if (allVaadinMeetups != null) {
			if (allVaadinMeetups.isEmpty()) {
				try {
					allVaadinMeetups = MeetupsService.getAllVaadinMeetups();
				} catch (Exception e) {
					Notification
							.show("Meetups groups unavailable, Please try again later",
									Type.WARNING_MESSAGE);
				}
			}

			for (Group meetupGroup : allVaadinMeetups) {
				Embedded photo;
				if (meetupGroup.getPhotoUrl() == null
						|| meetupGroup.getPhotoUrl().isEmpty()) {

					photo = new Embedded(null, new ThemeResource(MEETUP_ICON));
				} else {
					photo = new Embedded(null, new ExternalResource(
							meetupGroup.getPhotoUrl()));
				}
				photo.setWidth("50px");
				photo.setHeight("50px");
				RowOfData rowOfData = new RowOfData(photo, new Label(
						meetupGroup.getName()), meetupGroup);
				rowOfData.addLayoutClickListener(new LayoutClickListener() {

					@Override
					public void layoutClick(LayoutClickEvent event) {
						getNavigationManager().navigateTo(
								new MeetupInfoView((Group) ((RowOfData) event
										.getComponent()).getObject()));

					}
				});
				content.addComponent(rowOfData);
			}
		}
	}

	public MeetupsView(HomeView homeView) {
		this.homeView = homeView;
		setCaption("Vaadin Meetups");
		content.setSizeFull();
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}
}
