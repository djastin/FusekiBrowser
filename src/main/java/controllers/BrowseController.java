package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import models.core.TripleManager;

public class BrowseController implements Controller
{
	private TripleManager tripleManager;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		ModelAndView mv = new ModelAndView("browse-data");
		tripleManager = TripleManager.getTripleManager();
		
		tripleManager.findTriples("test");
		mv.addObject("triple_results", tripleManager.getTriples());
			
		return mv;
	}

}
