package org.vaadin.tunis.vaadincommunityapp.model;

import java.util.Date;

public class Photo {
	private String memberName;
	private String memberId;
	private String photoLink;
	private String highresLink;
	private String thumbLink;
	private String photoId;
	private Date createdDate;
	private Date updatedDate;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getHighresLink() {
		return highresLink;
	}

	public void setHighresLink(String highresLink) {
		this.highresLink = highresLink;
	}

	public String getThumbLink() {
		return thumbLink;
	}

	public void setThumbLink(String thumbLink) {
		this.thumbLink = thumbLink;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
