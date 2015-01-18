package org.vaadin.tunis.vaadincommunityapp.ui;

import java.util.List;

import org.vaadin.tunis.vaadincommunityapp.model.Group;
import org.vaadin.tunis.vaadincommunityapp.model.Photo;
import org.vaadin.tunis.vaadincommunityapp.services.meetupapi.MeetupsService;
import org.vaadin.tunis.vaadincommunityapp.ui.composite.PopoverPhotoContent;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;

@SuppressWarnings("serial")
public class MeetupPhotosView extends NavigationView {
	MeetupPhotosView instance;

	public MeetupPhotosView(Group meetupGroup) {
		instance = this;
		setCaption("Photos ");
		List<Photo> meetupPhotos = MeetupsService.getMeetupPhotos(meetupGroup
				.getGroupUrlName());
		int rows = (meetupPhotos.size() / 5) + 1;
		GridLayout gridLayout = new GridLayout(5, rows);
		gridLayout.setWidth("100%");
		int screenWidth = Page.getCurrent().getBrowserWindowWidth();
		int photoWidth = screenWidth / 5;
		int i = 0;
		if (!meetupPhotos.isEmpty()) {
			do {
				for (int j = 0; j < 5; j++) {
					final Photo photo = meetupPhotos.get((i) * 4 + j);
					ExternalResource externalPhoto = new ExternalResource(
							photo.getThumbLink());
					Embedded embedded = new Embedded(null, externalPhoto);
					embedded.setHeight(photoWidth - 10 + "px");
					embedded.setWidth(photoWidth - 10 + "px");
					embedded.addClickListener(new ClickListener() {

						@Override
						public void click(ClickEvent event) {
							Embedded photoView = new Embedded(null,new ExternalResource(photo.getPhotoLink()));
							PopoverPhotoContent photoContent = new PopoverPhotoContent(
									photoView);
							photoContent.showRelativeTo(instance);

						}
					});
					gridLayout.addComponent(embedded, j, i);
					gridLayout.setComponentAlignment(embedded,
							Alignment.MIDDLE_CENTER);
					gridLayout.setSpacing(true);
				}
				i++;
			} while (rows > i);
		}
		setContent(gridLayout);
	}
}