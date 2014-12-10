package org.vaadin.tunis.VaadinCommunityApp.ui;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;

@SuppressWarnings("serial")
public class MenuView extends NavigationView {

    public MenuView() {
    	final MembersView membersView = new MembersView("Vaadin-Tunis");
        setCaption("Menu");

        final VerticalComponentGroup content = new VerticalComponentGroup();
        NavigationButton button = new NavigationButton("Meetups");
        button.addClickListener(new NavigationButtonClickListener() {
            @Override
            public void buttonClick(NavigationButtonClickEvent event) {
                getNavigationManager().navigateTo(new MeetupsView());
            }
        });
        NavigationButton memberButton = new NavigationButton("Members");
        memberButton.addClickListener(new NavigationButtonClickListener() {
            @Override
            public void buttonClick(NavigationButtonClickEvent event) {
                
				getNavigationManager().navigateTo(membersView);
            }
        });
        
        content.addComponent(button);
        content.addComponent(memberButton);
        setContent(content);
    };
}
