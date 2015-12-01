/*package controllers.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchEngineServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public SearchEngineServlet() { }
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		JSONObject json = new JSONObject();
		
		try 
		{
			json.put("name", "java");
			json.put("company", "oracle");
		} 
		catch (JSONException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	

}*/
