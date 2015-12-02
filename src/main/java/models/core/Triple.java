package models.core;

import com.fasterxml.jackson.annotation.JsonView;

import views.jsonviews.Views;

public class Triple
{
	@JsonView(Views.Public.class)
	private String subject;
	@JsonView(Views.Public.class)
	private String predicate;
	@JsonView(Views.Public.class)
	private String object;
	
	public Triple(String subject, String predicate, String object)
	{
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getPredicate()
	{
		return predicate;
	}

	public void setPredicate(String predicate) 
	{
		this.predicate = predicate;
	}

	public String getObject()
	{
		return object;
	}

	public void setObject(String object)
	{
		this.object = object;
	}
	
	

}
