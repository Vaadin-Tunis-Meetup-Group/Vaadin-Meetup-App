package org.vaadin.tunis.vaadincommunityapp.model;



import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *  
 *   Event
 *
 */
public class Events
{
	private String longitude;
	private String latitude;
	
	
	private Integer rsvpCount;
	
	
	private Integer maybeRsvpCount;
	
	private String groupName;
	
	private String groupId;
	
	
	private String feeCurrency;
	private Date time;
	private Calendar updated;
	
	
	private Boolean isMeetup;
	
	private Boolean allowMaybeRsvp;
	
	
	private Boolean noRsvpCount;
	
	private String eventUrl;
	
	
	private Integer attendeeCount;
	
	private Integer rsvpLimit;
	
	private String id;
	private String organizerId;
	private String organizerName;
	
	
	private String venueLongitude;
	
	private String venueLatitude;
	private BigDecimal fee;
	
	private String venueId;
	
	private String venueName;

	private String venueState;
	private String venueCity;
	private String venueZip;
	private String venueMap;
	private String venueVisibility;
	private String venuePhone;
	
	private String venueAddress1;
	private String venueAddress2;
	private String venueAddress3;
	
	private String description;
	private String photoUrl;
	
	private String groupPhotoUrl;
	
	
	private String feeDescription;
	private String questions;
	private String name;
	
	
	private String myRsvp;
	
	
	private Calendar rsvpCutoff;
	
	private String status;
	
	private Boolean rsvpClosed;
	
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
	public Integer getRsvpCount()
	{
		return rsvpCount;
	}
	public void setRsvpCount(Integer rsvpCount)
	{
		this.rsvpCount = rsvpCount;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	public String getFeeCurrency()
	{
		return feeCurrency;
	}
	public void setFeeCurrency(String feeCurrency)
	{
		this.feeCurrency = feeCurrency;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public Calendar getUpdated()
	{
		return updated;
	}
	public void setUpdated(Calendar updated)
	{
		this.updated = updated;
	}
	public Boolean getIsMeetup()
	{
		return isMeetup;
	}
	public void setIsMeetup(Boolean isMeetup)
	{
		this.isMeetup = isMeetup;
	}
	public String getEventUrl()
	{
		return eventUrl;
	}
	public void setEventUrl(String eventUrl)
	{
		this.eventUrl = eventUrl;
	}
	public Integer getAttendeeCount()
	{
		return attendeeCount;
	}
	public void setAttendeeCount(Integer attendeeCount)
	{
		this.attendeeCount = attendeeCount;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getVenueLongitude()
	{
		return venueLongitude;
	}
	public void setVenueLongitude(String venueLongitude)
	{
		this.venueLongitude = venueLongitude;
	}
	public String getVenueLatitude()
	{
		return venueLatitude;
	}
	public void setVenueLatitude(String venueLatitude)
	{
		this.venueLatitude = venueLatitude;
	}
	public BigDecimal getFee()
	{
		return fee;
	}
	public void setFee(BigDecimal fee)
	{
		this.fee = fee;
	}
	public String getVenueName()
	{
		return venueName;
	}
	public void setVenueName(String venueName)
	{
		this.venueName = venueName;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getPhotoUrl()
	{
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}
	public String getFeeDescription()
	{
		return feeDescription;
	}
	public void setFeeDescription(String feeDescription)
	{
		this.feeDescription = feeDescription;
	}
	public String getQuestions()
	{
		return questions;
	}
	public void setQuestions(String questions)
	{
		this.questions = questions;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	
	public String getMyRsvp()
	{
		return myRsvp;
	}
	
	public void setMyRsvp(String s)
	{
		this.myRsvp = s;
	}
	
	public String toString()
	{
		return ToStringBuilder.build(this);
	}

	public Calendar getRsvpCutoff()
	{
		return rsvpCutoff;
	}
	
	public void setRsvpCutoff(Calendar c)
	{
		this.rsvpCutoff = c;
	}
	
	public boolean hasRsvpCutoff()
	{
		return (this.getRsvpCutoff() != null);
	}
	
	public String getVenueState()
	{
		return venueState;
	}
	
	public void setVenueState(String vs)
	{
		this.venueState = vs;
	}
	
	public String getVenueAddress1()
	{
		return venueAddress1;
	}
	
	public void setVenueAddress1(String va1)
	{
		this.venueAddress1 = va1;
	}
	
	public String getVenueAddress2()
	{
		return venueAddress2;
	}
	
	public void setVenueAddress2(String va2)
	{
		this.venueAddress2 = va2;
	}
	
	public String getVenueAddress3()
	{
		return venueAddress3;
	}
	
	public void setVenueAddress3(String va3)
	{
		this.venueAddress3 = va3;
	}
	
	public String getOrganizerId()
	{
		return organizerId;
	}
	
	public void setOrganizerId(String oid)
	{
		this.organizerId = oid;
	}
	public String getVenueId()
	{
		return venueId;
	}
	public void setVenueId(String venueId)
	{
		this.venueId = venueId;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public boolean isRsvpClosed()
	{
		if (rsvpClosed == null)
		{
			return false;
		}
		else
		{
			return rsvpClosed.booleanValue();
		}
	}
	
	public void setRsvpClosed(Boolean rsvpClosed)
	{
		this.rsvpClosed = rsvpClosed;
	}
	
	public Integer getMaybeRsvpCount()
	{
		return maybeRsvpCount;
	}
	
	public void setMaybeRsvpCount(Integer maybeRsvpCount)
	{
		this.maybeRsvpCount = maybeRsvpCount;
	}
	
	public String getGroupId()
	{
		return groupId;
	}
	
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}
	public String getOrganizerName()
	{
		return organizerName;
	}
	public void setOrganizerName(String organizerName)
	{
		this.organizerName = organizerName;
	}
	public String getVenueCity()
	{
		return venueCity;
	}
	public void setVenueCity(String venueCity)
	{
		this.venueCity = venueCity;
	}
	public String getVenueZip()
	{
		return venueZip;
	}
	public void setVenueZip(String venueZip)
	{
		this.venueZip = venueZip;
	}
	public String getVenueMap()
	{
		return venueMap;
	}
	public void setVenueMap(String venueMap)
	{
		this.venueMap = venueMap;
	}
	
	public String getVenueVisibility()
	{
		return venueVisibility;
	}
	
	public void setVenueVisibility(String venueVisibility)
	{
		this.venueVisibility = venueVisibility;
	}
	
	public String getGroupPhotoUrl()
	{
		return groupPhotoUrl;
	}
	
	public void setGroupPhotoUrl(String groupPhotoUrl)
	{
		this.groupPhotoUrl = groupPhotoUrl;
	}
	
	public Boolean getAllowMaybeRsvp()
	{
		if (allowMaybeRsvp == null)
		{
			return false;
		}
		else
		{
			return allowMaybeRsvp;
		}
	}
	
	public void setAllowMaybeRsvp(Boolean allowMaybeRsvp)
	{
		this.allowMaybeRsvp = allowMaybeRsvp;
	}
	
	public Boolean getNoRsvpCount()
	{
		if (noRsvpCount == null)
		{
			return true;
		}
		
		return noRsvpCount;
	}
	
	public void setNoRsvpCount(Boolean noRsvpCount)
	{
		this.noRsvpCount = noRsvpCount;
	}
	
	public Integer getRsvpLimit()
	{
		return rsvpLimit;
	}
	
	public void setRsvpLimit(Integer limit)
	{
		this.rsvpLimit = limit;
	}
	
	public String getVenuePhone()
	{
		return venuePhone;
	}
	
	public void setVenuePhone(String venuePhone)
	{
		this.venuePhone = venuePhone;
	}
	

	
}
