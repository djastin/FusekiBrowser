package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import models.core.TripleManager;

@RestController
public class AjaxController
{	
	@RequestMapping("/ajax")
	public ModelAndView helloAjaxTest() 
	{
		return new ModelAndView("main");
	}
	
	@RequestMapping(value = "/search/api/getSearchResult")
	public TripleManager getSearchResultViaAjax(@RequestBody String search)
	{
		System.out.println("Ajax test: " + search);
		
		return null;
	}	
}
