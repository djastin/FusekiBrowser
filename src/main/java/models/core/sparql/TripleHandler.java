package models.core.sparql;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.log4j.Logger;

public class TripleHandler
{
	private static TripleHandler instance;
	private static Logger log;
	private String port = "3030";
	
	private TripleHandler()
	{
		log = Logger.getLogger(TripleHandler.class);
	}
	
	public static TripleHandler getTripleHandler()
	{
		if(instance == null)
		{
			instance = new TripleHandler();
		}
		
		return instance;
	}
	
	public QueryExecution executeQuery(String dataset, String query)
	{
		return QueryExecutionFactory.sparqlService(
				"http://localhost:" + port + "/" + dataset + "/query", query);
	}
	
	public QueryExecution select(String dataset, int limit)
	{
		QueryExecution qe = executeQuery(dataset, "SELECT * WHERE {?x ?r ?y} LIMIT " + limit);
		log.info("select triples");
				
		return qe;
	}
	
	public QueryExecution selectWithPredicate(String dataset, String predicate)
	{
		log.info("Select data with predicate filter " + dataset);
		
		String query = "SELECT * WHERE {?x ?r ?y .FILTER (?r = <" + predicate.replace("\"", "") + ">)}" +
				"LIMIT 100";
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", query);
		
		if(!qe.execSelect().hasNext())
		{
			qe = null;
			
			query = "SELECT * WHERE {?x ?r ?y .FILTER (?r = " + predicate + ")}" +
					"LIMIT 100";
			
			System.out.println("Recover predicate query: " + query);
			
			qe = QueryExecutionFactory.sparqlService(
					"http://localhost:3030/" + dataset + "/query", query);
		}
		
		System.out.println("Query Predicate: SELECT * WHERE {?x ?r ?y .FILTER (?r = <" + predicate.replace("\"", "") + ">)}" +
							"LIMIT 100");
						
		return qe;
	}
	
	public QueryExecution selectWithSubject(String dataset, String subject)
	{
		log.info("Select data with subject filter " + dataset);
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", ""
						+ "SELECT * WHERE {?x ?r ?y .FILTER (?x = <" + subject.replace("\"", "") + ">)}" +
							"LIMIT 100");
		
		System.out.println("Query Subject: " + "SELECT * WHERE {?x ?r ?y .FILTER (?x = <" + subject.replace("\"", "") + ">)}" +
							"LIMIT 100");
				
		return qe;
	}
	
	public QueryExecution selectWithObject(String dataset, String object)
	{
		String query = ""
				+ "SELECT * WHERE {?x ?r ?y .FILTER (?y = " + object + ")}" +
				"LIMIT 100";
		
		log.info("Select data with object filter " + dataset);
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", query);
		
		if(!qe.execSelect().hasNext())
		{
			qe = null;
			
			query = ""
					+ "SELECT * WHERE {?x ?r ?y .FILTER (?y = <"+ object.replace("\"", "") + ">)}" +
					"LIMIT 100";
			
			System.out.println("Recover query: " + query);
			
			qe = QueryExecutionFactory.sparqlService(
					"http://localhost:3030/" + dataset + "/query", query);
		}
		
		System.out.println("Query Object: " + "SELECT * WHERE {?x ?r ?y .FILTER (?y = " + object + ")}" +
							"LIMIT 100");
		
		return qe;
	}
}
