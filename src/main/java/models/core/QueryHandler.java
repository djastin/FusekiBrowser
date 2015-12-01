package models.core;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class QueryHandler 
{
	static Logger log = Logger.getLogger(QueryHandler.class);
	
	public QueryHandler() 
	{
		BasicConfigurator.configure();
	}
	
	public ResultSet selectDatasets()
	{
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + "/query", "SELECT ?s WHERE {?s ?p ?o .}");
		ResultSet results = qe.execSelect();
		ResultSetFormatter.out(System.out, results);
		
		qe.close();
		
		return results;
	}
	
	public ResultSet select(String dataset)
	{
		log.info("Add data to triplestore " + dataset);
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/" + dataset + "/query", "SELECT * WHERE {?x ?r ?y}");
		ResultSet results = qe.execSelect();
		ResultSetFormatter.out(System.out, results);
		
		qe.close();
		
		return results;
	}
}
