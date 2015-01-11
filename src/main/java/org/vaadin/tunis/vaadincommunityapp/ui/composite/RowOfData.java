package org.vaadin.tunis.vaadincommunityapp.ui.composite;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class RowOfData extends HorizontalLayout {
	private Component leftComponent;
	private Component rightComponent;
	private Object object;

	public RowOfData(Component leftComponent, Component rightComponent,
			Object object) {
		super();
		this.setLeftComponent(leftComponent);
		this.setRightComponent(rightComponent);
		this.setObject(object);
		addComponent(leftComponent);
		setComponentAlignment(leftComponent, Alignment.MIDDLE_CENTER);
		addComponent(rightComponent);
		setComponentAlignment(rightComponent, Alignment.MIDDLE_LEFT);
		setExpandRatio(rightComponent, 1f);
		setHeight("50px");
		setWidth("100%");
		setSpacing(true);
	}

	public RowOfData(Component component, Object object) {
		super();
		this.setLeftComponent(component);
		this.setObject(object);
		addComponent(this.leftComponent);
		setWidth("100%");
		setHeight("100px");
		setSpacing(true);
	}

	public RowOfData(Component component) {
		super();
		this.setLeftComponent(component);
		addComponent(this.leftComponent);
		setWidth("100%");
		setHeight("18px");
		setSpacing(true);
	}

	public Component getRightComponent() {
		return rightComponent;
	}

	public void setRightComponent(Component component) {
		this.rightComponent = component;
	}

	public Component getLeftComponent() {
		return leftComponent;
	}

	public void setLeftComponent(Component component) {
		this.leftComponent = component;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
