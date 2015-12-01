package controllers;
 
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import models.core.sql.DatasetHandler;
 
public class MainController implements Controller
{ 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		ArrayList<String> dataset_results = DatasetHandler.getHandler().select();
		
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("datasets", dataset_results);
		
		return mv;
	}
}