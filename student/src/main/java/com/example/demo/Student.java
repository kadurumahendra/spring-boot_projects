package com.example.demo;

public class Student {
	
	private Integer id;
	private String name;
	private String course;
	private Integer marks;
	
	public Student()
	{
		
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id= id;
		
	}
	public String getName()
	{
		return name;
	}
	public void SetName(String name)
	{
		this.name = name;
	}
	public String getCourse()
	{
		return course;
	}
	public void setCourse(String course)
	{
		this.course = course;
	}
	
	public Integer getMarks()
	{
		return marks;
	}
	public void setMarks(Integer marks)
	{
		this.marks = marks;
	}

}
