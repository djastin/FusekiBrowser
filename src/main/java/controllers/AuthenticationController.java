package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController
{
	@RequestMapping("/signin")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name)
	{ 
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", "");
		mv.addObject("name", name);
		
		
		return mv;
	}
}
