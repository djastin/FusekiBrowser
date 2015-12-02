package models.core;

import java.util.ArrayList;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import com.fasterxml.jackson.annotation.JsonView;
import models.core.sparql.TripleHandler;
import views.jsonviews.Views;

public class TripleManager
{
	private static TripleManager instance;
	@JsonView(Views.Public.class)
	private ArrayList<Triple> triples;
	private TripleHandler tripleHandler;
	
	private TripleManager()
	{
		tripleHandler = TripleHandler.getTripleHandler();
		triples = new ArrayList<Triple>();
	}
	
	public static TripleManager getTripleManager()
	{
		if(instance == null)
		{
			instance = new TripleManager();
		}
		return instance;
	}
	
	private String cleanHashtags(String input)
	{
		String output = "";
		
		if (input.contains("#"))
		{
			int i = input.indexOf("#") + 1;
			output = input.substring(i, input.length());
		}
		else
		{
			output = input;
		}
		return output;
	}
	
	public void findTriples(String dataset)
	{
		QueryExecution qe = tripleHandler.select(dataset, 100);
		ResultSet results = qe.execSelect();
		
		while(results.hasNext())
		{
			QuerySolution qs = results.nextSolution();
			
			String subject = cleanHashtags(qs.get("?x").toString());
			String predicate = cleanHashtags(qs.get("?r").toString());
			String object = cleanHashtags(qs.get("?y").toString());
			
			Triple triple_result = new Triple(subject, predicate, object);
			triples.add(triple_result);
		}
		
		qe.close();
	}
	
	public ArrayList<Triple> getTriples()
	{
		return triples;
	}
	
	public void clearTriples()
	{
		triples.clear();
	}

}
