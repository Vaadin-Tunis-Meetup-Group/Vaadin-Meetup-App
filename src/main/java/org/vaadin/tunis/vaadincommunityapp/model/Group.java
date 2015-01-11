package org.vaadin.tunis.vaadincommunityapp.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Group
{
	
	private String name;
	
	private String joinMode;
	
	//new properties
	private String shortLink;
	private String joinInfo;
	private String visibility;
	
	private String groupPhotoCount;
	
	private String groupUrlName;
	
	private String who;
	
	private List<Topic> topics = new ArrayList<Topic>();
	
	private String longitude;
	private String latitude;
	private String state;
	private String id;
	private String zip;
	
	private BigDecimal rating;
	
	private String organizerProfileUrl;
	
	private String organizerId;
	private String organizerName;
	
	private String country;
	private String photoUrl;
	private Calendar created;
	private Calendar updated;
	private Integer members;
	private String link;
	private String city;
	private String description;
	
	private Integer daysLeft;
	
	public Group()
	{
		super();
	}

	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getLongitude()
	{
		return longitude;
	}


	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}


	public String getLatitude()
	{
		return latitude;
	}


	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}


	public String getState()
	{
		return state;
	}


	public void setState(String state)
	{
		this.state = state;
	}


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getZip()
	{
		return zip;
	}


	public void setZip(String zip)
	{
		this.zip = zip;
	}


	public String getOrganizerProfileUrl()
	{
		return organizerProfileUrl;
	}


	public void setOrganizerProfileUrl(String url)
	{
		this.organizerProfileUrl = url;
	}


	public String getCountry()
	{
		return country;
	}


	public void setCountry(String country)
	{
		this.country = country;
	}


	public String getPhotoUrl()
	{
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}


	public Calendar getCreated()
	{
		return created;
	}


	public void setCreated(Calendar created)
	{
		this.created = created;
	}


	public Calendar getUpdated()
	{
		return updated;
	}


	public void setUpdated(Calendar updated)
	{
		this.updated = updated;
	}


	public Integer getMembers()
	{
		return members;
	}


	public void setMembers(Integer members)
	{
		this.members = members;
	}


	public String getLink()
	{
		return link;
	}


	public void setLink(String link)
	{
		this.link = link;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public Integer getDaysLeft()
	{
		return daysLeft;
	}


	public void setDaysLeft(Integer daysLeft)
	{
		this.daysLeft = daysLeft;
	}


	
	public String getJoinMode()
	{
		return joinMode;
	}

	public void setJoinMode(String joinMode)
	{
		this.joinMode = joinMode;
	}

	public String getGroupPhotoCount()
	{
		return groupPhotoCount;
	}

	public void setGroupPhotoCount(String groupPhotoCount)
	{
		this.groupPhotoCount = groupPhotoCount;
	}

	public String getGroupUrlName()
	{
		return groupUrlName;
	}

	public void setGroupUrlName(String groupUrlName)
	{
		this.groupUrlName = groupUrlName;
	}

	public String getWho()
	{
		return who;
	}

	public void setWho(String who)
	{
		this.who = who;
	}

	public List<Topic> getTopics()
	{
		return topics;
	}

	public void setTopics(List<Topic> topics)
	{
		this.topics = topics;
	}

	public BigDecimal getRating()
	{
		return rating;
	}

	public void setRating(BigDecimal rating)
	{
		this.rating = rating;
	}

	public String getOrganizerId()
	{
		return organizerId;
	}

	public void setOrganizerId(String organizerId)
	{
		this.organizerId = organizerId;
	}

	public String getOrganizerName()
	{
		return organizerName;
	}

	public void setOrganizerName(String organizerName)
	{
		this.organizerName = organizerName;
	}

	public String toString()
	{
		return ToStringBuilder.build(this);
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public String getJoinInfo() {
		return joinInfo;
	}

	public void setJoinInfo(String joinInfo) {
		this.joinInfo = joinInfo;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
}
