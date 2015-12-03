package models.core.sparql;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
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
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", ""
						+ "SELECT * WHERE {?x ?r ?y .FILTER (?r = <" + predicate.replace("\"", "") + ">)}" +
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
				
		return qe;
	}
	
	public QueryExecution selectWithObject(String dataset, String object)
	{
		log.info("Select data with object filter " + dataset);
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", ""
						+ "SELECT * WHERE {?x ?r ?y .FILTER (?y = " + object + ")}" +
							"LIMIT 100");
		
		return qe;
	}
}
