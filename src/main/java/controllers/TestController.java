package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.ResultSet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import models.core.QueryHandler;
 
public class TestController implements Controller
{
	private QueryHandler queryHandler;
	
	public void setQueryHandler(QueryHandler queryHandler)
	{
		this.queryHandler = queryHandler;
	}
	
	public QueryHandler getQueryHandler()
	{
		return queryHandler;
	}
 
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		queryHandler = new QueryHandler();
		ResultSet results = queryHandler.select("ds");
		
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("datasets", results);
		
		return mv;
	}
}