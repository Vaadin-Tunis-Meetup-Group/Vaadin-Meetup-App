package org.vaadin.tunis.VaadinCommunityApp.ui.composite;

import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class RowOfData extends HorizontalLayout {
	private Embedded photo;
	private Component component;
	private Object object;

	public RowOfData(Embedded photo, Component component, Object object) {
		super();
		this.setPhoto(photo);
		this.setComponent(component);
		this.setObject(object);
		addComponent(photo);
		addComponent(component);
		setExpandRatio(component, 1f);
		setHeight("50px");
		setWidth("100%");
		setSpacing(true);
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Embedded getPhoto() {
		return photo;
	}

	public void setPhoto(Embedded photo) {
		this.photo = photo;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}	
}
