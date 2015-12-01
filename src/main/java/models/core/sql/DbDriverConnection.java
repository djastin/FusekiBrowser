package models.core.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDriverConnection 
{
	protected Connection con;
	protected String jdbcUrl, username, password;
		
	public DbDriverConnection() 
	{ 
		jdbcUrl = "jdbc:mysql://localhost:8889/fusekibrowser";
		username = "root";
		password = "root";
	}
	
	protected ResultSet executeQuery(String sql)
	{
		createConnection();
		ResultSet rs = null;
		Statement stmt;
		
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	protected String createConnection()
	{
		String error = "";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, username, password);
		} 
		catch (ClassNotFoundException e) 
		{
			error += ";" + e.getMessage();
		} 
		catch (SQLException e) 
		{
			error += ";" + e.getMessage();
		}
		
		return error;
	}
	
	protected String closeConnection()
	{
		String error = "";
		
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			error = e.getMessage();
		}
		
		return error;
	}
	
}
