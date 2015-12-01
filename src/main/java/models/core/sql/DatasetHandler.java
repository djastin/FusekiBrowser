package models.core.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.lang3.text.WordUtils;

public class DatasetHandler extends DbDriverConnection
{
	private static DatasetHandler instance;
	
	private DatasetHandler() { }
	
	public static DatasetHandler getHandler()
	{
		if(instance == null)
		{
			instance = new DatasetHandler();
		}
		return instance;
	}
	
	public ArrayList<String> find(String keyword)
	{
		ResultSet rs = executeQuery("select `data` from `dump` where `data` like '%" + keyword + "%'");
		ArrayList<String> results = new ArrayList<>();
		
		try 
		{
			while (rs.next()) 
			{
				String result = rs.getString("data");
				results.add(WordUtils.capitalize(result));
			}
		} 
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			closeConnection();
		}
		
		return results;
	}
	
	public ArrayList<String> select()
	{
		ResultSet rs = executeQuery("SELECT `data` from `dump`");		
		ArrayList<String> results = new ArrayList<>();
		
		try 
		{
			while (rs.next()) 
			{
				String result = rs.getString("data");
				results.add(WordUtils.capitalize(result));
			}
		} 
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return results;
	}
}
