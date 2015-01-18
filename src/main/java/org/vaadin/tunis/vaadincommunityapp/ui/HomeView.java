package org.vaadin.tunis.vaadincommunityapp.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@SuppressWarnings("serial")
public class HomeView extends NavigationView {
	Toolbar toolbar = new Toolbar();
	static String ERROR_MESSAGE = "Please check your internet connection";
	public final Button blogsButton = new Button("Blog");
	public final Button addonsButton = new Button("Addons");
	public final Button meetupsButtons = new Button("Meetups");
	private HomeView instance;

	public HomeView() {
		instance = this;
		setCaption("Home");
		setContent(new MapView());
		setToolbar(toolbar);
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

		
		blogsButton.setIcon(FontAwesome.RSS);
		blogsButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					blogsButton.setEnabled(false);
					getNavigationManager().navigateTo(new BlogsView());
					
					
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE, Type.WARNING_MESSAGE);
					blogsButton.setEnabled(true);
				}

			}
		});
		toolbar.addComponent(blogsButton);

		// Calendar api cause memory heap
		// Button calendarButton = new Button("Events");
		// calendarButton.setIcon(FontAwesome.CALENDAR);
		// calendarButton.addClickListener(new ClickListener() {
		//
		// @Override
		// public void buttonClick(ClickEvent event) {
		// try {
		// getNavigationManager().navigateTo(new EventsView());
		// } catch (Exception e) {
		// Notification.show(ERROR_MESSAGE, Type.WARNING_MESSAGE);
		// }
		//
		// }
		// });
		// toolbar.addComponent(calendarButton);

		
		addonsButton.setIcon(FontAwesome.PUZZLE_PIECE);
		addonsButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new AddonsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE, Type.WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(addonsButton);

		
		meetupsButtons.setIcon(FontAwesome.GROUP);
		meetupsButtons.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					getNavigationManager().navigateTo(new MeetupsView());
				} catch (Exception e) {
					Notification.show(ERROR_MESSAGE, Type.WARNING_MESSAGE);
				}

			}
		});
		toolbar.addComponent(meetupsButtons);

	}
}
