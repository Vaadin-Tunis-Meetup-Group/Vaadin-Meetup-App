package org.vaadin.tunis.VaadinCommunityApp.services;

import java.util.List;

import meetup.Member;
import meetup.MemberSearchCriteria;

public class MemberService {

	private static MeetupAPIServiceFactory meetupApiService = MeetupAPIServiceFactory.getInstance();
	
	public static List<Member> getMembersByGroupUrlName(String groupUrlName){
		MemberSearchCriteria criteria = new MemberSearchCriteria();
		criteria.setGroup_urlname(groupUrlName);
		return meetupApiService.getMeetupClient().getMembers(criteria);
	}
}
