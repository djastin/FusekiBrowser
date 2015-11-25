package controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class JenaTestController 
{ 
	@RequestMapping("/test")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) 
	{
		//testJena();
		ModelAndView mv = new ModelAndView("test");
		
		return mv;
	}
}