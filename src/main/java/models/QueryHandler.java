package models;

import org.apache.log4j.Logger;

public class QueryHandler 
{
	private static final String UPDATE_TEMPLATE = 
            "PREFIX dc: <http://purl.org/dc/elements/1.1/>"
            + "INSERT DATA"
            + "{ <http://example/%s>    dc:title    \"A new book\" ;"
            + "                         dc:creator  \"A.N.Other\" ." + "}   ";
	static Logger log = Logger.getLogger(QueryHandler.class);
	
	public QueryHandler()
	{
		test();
	}
	
	public void test()
	{
		/*BasicConfigurator.configure();
		log.info("Add data to triplestore");
		
		String id = UUID.randomUUID().toString();
		System.out.println(String.format("Adding %s", id));
		UpdateProcessor upp = UpdateExecutionFactory.createRemote(
				UpdateFactory.create(String.format(UPDATE_TEMPLATE, id))
				, "http://localhost:3030/ds/update");
		
		upp.execute();
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(
				"http://localhost:3030/ds/query", "SELECT * WHERE {?x ?r ?y}");
		ResultSet results = qe.execSelect();
		ResultSetFormatter.out(System.out, results);
		qe.close();*/
	}

}
