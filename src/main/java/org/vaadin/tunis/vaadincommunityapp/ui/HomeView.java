package org.vaadin.tunis.vaadincommunityapp.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class HomeView extends NavigationView {
	Toolbar toolbar = new Toolbar();
	static String ERROR_MESSAGE = "Please check your internet connection";

	private HomeView instance;
	private static String HOME_SCREEN_IMG = "images/vaadin-tunis.png";
	private AbsoluteLayout layout = new AbsoluteLayout();

	public HomeView() {
		instance = this;
		setCaption("Home");
		setToolbar(toolbar);
		Embedded img = new Embedded(null, new ThemeResource(HOME_SCREEN_IMG));
		img.setSizeFull();
		layout.setSizeFull();
		layout.addComponent(img, "left: 15%; right: 15%;"
				+ "top: 25%; bottom: 25%;");
		setContent(layout);
		initToolbar();
	}

	private void initToolbar() {
		Button homeButton = new Button("Home");
		homeButton.setIcon(FontAwesome.HOME);
		homeButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(instance);

			}
		});
		toolbar.addComponent(homeButton);

		Button blogsButton = new Button("Blog");
		blogsButton.setIcon(FontAwesome.RSS);
		blogsButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new BlogsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE,
							Notification.TYPE_WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(blogsButton);

		Button calendarButton = new Button("Events");
		calendarButton.setIcon(FontAwesome.CALENDAR);
		calendarButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new EventsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE,
							Notification.TYPE_WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(calendarButton);

		Button addonsButton = new Button("Addons");
		addonsButton.setIcon(FontAwesome.PUZZLE_PIECE);
		addonsButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new AddonsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE,
							Notification.TYPE_WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(addonsButton);

		Button meetupsButtons = new Button("Meetups");
		meetupsButtons.setIcon(FontAwesome.GROUP);
		meetupsButtons.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new MeetupsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE,
							Notification.TYPE_WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(meetupsButtons);

	}
}
