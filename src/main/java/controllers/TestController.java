package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import models.QueryHandler;
 
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
		//queryHandler.test();
		
		ModelAndView mv = new ModelAndView("test");
		//mv.addObject("queryHandler", this.employeeManager.getEmployees());
		
		return mv;
	}
}