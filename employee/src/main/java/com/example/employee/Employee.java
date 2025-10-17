package com.example.employee;

public class Employee {
	private Integer id;
	private String empname;
	private String dept;
	private Double salary;
	
	public Employee()
	{
		
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getEmpname()
	{
		return empname;
	}
	
	public void setEmpname(String empname)
	{
		this.empname= empname;
	}
	public String getDept()
	{
		return dept;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}
	
	public Double getSalary()
	{
		return salary;
	}
	public void setSalary(Double salary)
	{
		this.salary = salary;
	}

}
