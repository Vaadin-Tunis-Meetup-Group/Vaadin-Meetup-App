package org.vaadin.tunis.VaadinCommunityApp.ui;

import java.util.List;

import meetup.Member;

import org.vaadin.tunis.VaadinCommunityApp.services.MemberService;
import org.vaadin.tunis.VaadinCommunityApp.ui.composite.RowOfData;

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

@SuppressWarnings("serial")
public class MembersView extends NavigationView {
	static String userIcon = "../../icons/user.png";

	public MembersView(String groupUrlName) {
		setCaption("Members");
		final VerticalComponentGroup content = new VerticalComponentGroup();
		content.setSizeFull();

		List<Member> membersByGroupUrlName = MemberService
				.getMembersByGroupUrlName(groupUrlName);

		for (Member member : membersByGroupUrlName) {
			Embedded photo;
			if (member.getPhotoUrl() == null || member.getPhotoUrl().isEmpty()) {
				photo = new Embedded(null, new ThemeResource(userIcon));
			} else {
				photo = new Embedded(null, new ExternalResource(
						member.getPhotoUrl()));
			}
			photo.setWidth("50px");
			photo.setHeight("50px");
			photo.addStyleName("circular");
			RowOfData rowOfData = new RowOfData(photo, new Label(
					member.getName()),member);
			rowOfData.addLayoutClickListener(new LayoutClickListener() {
				
				@Override
				public void layoutClick(LayoutClickEvent event) {
					Notification.show(((RowOfData)event.getComponent()).getLabel().getValue());
					
					
				}
			});
			content.addComponent(rowOfData);
		}
		CssLayout cssLayout = new CssLayout(content);
		setContent(cssLayout);
	}
}
