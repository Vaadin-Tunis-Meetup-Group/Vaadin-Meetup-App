package org.vaadin.tunis.vaadincommunityapp.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class HomeView extends NavigationView {
	Toolbar toolbar = new Toolbar();
	final VerticalComponentGroup content = new VerticalComponentGroup();
	private HomeView instance;

	public HomeView() {
		instance = this;
		setCaption("Home");
		content.setSizeFull();
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

		Button blogsButton = new Button("Blog");
		blogsButton.setIcon(FontAwesome.RSS);
		blogsButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(new BlogsView());

			}
		});
		toolbar.addComponent(blogsButton);

		Button calendarButton = new Button("Events");
		calendarButton.setIcon(FontAwesome.CALENDAR);
		toolbar.addComponent(calendarButton);
		
		Button addonsButton = new Button("Addons");
		addonsButton.setIcon(FontAwesome.PUZZLE_PIECE);
		addonsButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(new AddonsView());
				
			}
		});
		toolbar.addComponent(addonsButton);

		Button meetupsButtons = new Button("Meetups");
		meetupsButtons.setIcon(FontAwesome.GROUP);
		meetupsButtons.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getNavigationManager().navigateTo(new MeetupsView());

			}
		});
		toolbar.addComponent(meetupsButtons);

	}
}
