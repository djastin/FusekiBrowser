package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.text.WordUtils;
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
		
		tripleManager.clearTriples();
		
		String dataset_result = "";
		
		if(!request.getParameter("dataset").isEmpty())
			dataset_result = request.getParameter("dataset").toLowerCase();
			tripleManager.findTriples(dataset_result);
				
		mv.addObject("triple_results", tripleManager.getTriples());
		mv.addObject("selected_dataset", WordUtils.capitalize(dataset_result));
				
		return mv;
	}

}
