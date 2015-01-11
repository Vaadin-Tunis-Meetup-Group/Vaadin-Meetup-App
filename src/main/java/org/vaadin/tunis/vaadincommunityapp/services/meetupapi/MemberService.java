package org.vaadin.tunis.vaadincommunityapp.services.meetupapi;

import java.util.List;


public class MemberService {

	private static MeetupAPIServiceFactory MEETUP_API_SERVICE = MeetupAPIServiceFactory
			.getInstance();

	private MemberService() {
		// fix sonar violation
	}

//	public static List<Member> getMembersByGroupUrlName(String groupUrlName) {
//		MemberSearchCriteria criteria = new MemberSearchCriteria();
//		criteria.setGroup_urlname(groupUrlName);
//		return MEETUP_API_SERVICE.getMeetupClient().getMembers(criteria);
//	}
}
