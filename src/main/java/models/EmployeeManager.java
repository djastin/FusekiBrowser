package models;

import java.util.ArrayList;

public class EmployeeManager 
{
	private static ArrayList<Employee> employees;
	
	public EmployeeManager()
	{
		employees = new ArrayList<Employee>();
		employees.add(new Employee("djastin", "0000"));
		employees.add(new Employee("bonno", "00500"));

	}
	
	public ArrayList<Employee> getEmployees()
	{
		return employees;
	}
}
