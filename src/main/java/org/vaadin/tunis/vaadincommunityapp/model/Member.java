package org.vaadin.tunis.vaadincommunityapp.model;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Member
{
	private String id;
	private String name;
	private String link;
	private String photoUrl;
	private String bio;
	
	private String latitude;
	
	private String longitude;
	
	private String country;
	private String city;
	private String state;
	private Calendar joined;
	private String zip;
	private String otherServices;
	private String visited;
	private List<Topic> topics = new ArrayList<Topic>();
	private String lang;
	
	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getLink()
	{
		return link;
	}


	public void setLink(String link)
	{
		this.link = link;
	}


	public String getPhotoUrl()
	{
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}


	public String getBio()
	{
		return bio;
	}


	public void setBio(String bio)
	{
		this.bio = bio;
	}


	public String getLatitude()
	{
		return latitude;
	}


	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}


	public String getLongitude()
	{
		return longitude;
	}


	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}


	public String getCountry()
	{
		return country;
	}


	public void setCountry(String country)
	{
		this.country = country;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getState()
	{
		return state;
	}


	public void setState(String state)
	{
		this.state = state;
	}


	public Calendar getJoined() {
		return joined;
	}


	public void setJoined(Calendar joined) {
		this.joined = joined;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getOtherServices() {
		return otherServices;
	}


	public void setOtherServices(String otherServices) {
		this.otherServices = otherServices;
	}


	public String getVisited() {
		return visited;
	}


	public void setVisited(String visited) {
		this.visited = visited;
	}


	public String toString()
	{
		return ToStringBuilder.build(this);
	}


	public List<Topic> getTopics() {
		return topics;
	}


	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}
}
