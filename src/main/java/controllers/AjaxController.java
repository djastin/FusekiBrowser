package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import models.core.TripleManager;

@RestController
public class AjaxController
{	
	private TripleManager tripleManager;
	
	@RequestMapping("/ajax")
	public ModelAndView helloAjaxTest() 
	{
		return new ModelAndView("main");
	}
	
	@RequestMapping(value = "/search/api/getSearchResult")
	public TripleManager getSearchResultViaAjax(@RequestBody String search)
	{
		tripleManager = TripleManager.getTripleManager();
		tripleManager.clearTriples();
		
		if(search.indexOf("subject") == 1)
			tripleManager.filterTriplesWithSubject("google", search.replace("subject:", ""));
		else if(search.indexOf("predicate") == 1)
			tripleManager.filterTriplesWithPredicate("google", search.replace("predicate:", ""));
		else if(search.indexOf("object") == 1)
			tripleManager.filterTriplesWithObject("google", search.replace("object:", ""));
		
		System.out.println("Triples: " + tripleManager.getTriples());
		
		return tripleManager;
	}	
}
