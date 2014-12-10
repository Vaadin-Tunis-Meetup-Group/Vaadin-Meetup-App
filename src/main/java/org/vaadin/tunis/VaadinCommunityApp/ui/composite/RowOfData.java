package org.vaadin.tunis.VaadinCommunityApp.ui.composite;

import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class RowOfData extends HorizontalLayout {
	private Embedded photo;
	private Label label;
	private Object object;

	public RowOfData(Embedded photo, Label label, Object object) {
		super();
		this.setPhoto(photo);
		this.setLabel(label);
		this.setObject(object);
		addComponent(photo);
		addComponent(label);
		setExpandRatio(label, 1f);
		setHeight("50px");
		setWidth("100%");
		setSpacing(true);
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
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
