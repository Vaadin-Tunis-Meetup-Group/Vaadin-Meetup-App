package org.vaadin.tunis.vaadincommunityapp.ui.composite;

import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.Page;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class PopoverPhotoContent extends Popover {
	private VerticalComponentGroup layout;

	public PopoverPhotoContent(Embedded photo) {
		layout = new VerticalComponentGroup();
		layout.addComponent(photo);
		photo.setWidth("100%");
		photo.setHeight(Page.getCurrent().getBrowserWindowHeight()-100+"px");

		Label closeLabel = new Label("Close");
		closeLabel.addStyleName("blue");
		closeLabel.addStyleName("textcentered");
		closeLabel.addStyleName("closelabel");
		closeLabel.setHeight(30.0f, Unit.PIXELS);
		CssLayout wrapper = new CssLayout(closeLabel);
		wrapper.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(final LayoutClickEvent event) {
				close();
			}
		});
		wrapper.addStyleName("close-button-background");
		layout.addComponent(wrapper);
		layout.setWidth(Page.getCurrent().getBrowserWindowWidth(), Unit.PIXELS);
		layout.setHeight(Page.getCurrent().getBrowserWindowHeight(),
				Unit.PIXELS);
		setWidth(Page.getCurrent().getBrowserWindowWidth(), Unit.PIXELS);
		setContent(layout);
	}
};
