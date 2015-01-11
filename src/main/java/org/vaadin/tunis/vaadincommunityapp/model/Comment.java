package org.vaadin.tunis.vaadincommunityapp.model;



public class Comment
{
	private String text;
	
	public Comment()
	{
		super();
	}
	
	public Comment(String s)
	{
		this.setText(s);
	}
	
	

	public String getText()
	{
		return text;
	}

	public void setText(String s)
	{
		this.text = s;
	}

	public String toString()
	{
		return ToStringBuilder.build(this);
	}
}
