package models.core.ajax;

public class SearchCriteria 
{
	String object;
	String predicate;
	String subject;
	
	public String getObject()
	{
		return object;
	}
	
	public void setObject(String object) 
	{
		this.object = object;
	}
	
	public String getPredicate() 
	{
		return predicate;
	}
	
	public void setPredicate(String predicate) 
	{
		this.predicate = predicate;
	}
	
	public String getSubject() 
	{
		return subject;
	}
	
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

}
