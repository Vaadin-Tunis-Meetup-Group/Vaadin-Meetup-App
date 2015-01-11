package org.vaadin.tunis.vaadincommunityapp.model;



import java.util.Calendar;

public class Topic
{
	private String name;
	private Calendar updated;
	private Integer members;
	private String link;
	private String description;
	private String urlkey;
	private String id;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getUrlkey()
	{
		return urlkey;
	}

	public void setUrlkey(String urlkey)
	{
		this.urlkey = urlkey;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	
	public String toString()
	{
		return ToStringBuilder.build(this);
	}

}
