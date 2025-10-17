package com.example.demo;

public class Cars {
	private Integer id;
	private String brand;
	private String model;
	private Double price;
	
	public Cars()
	{
		
	}
	public Cars(Integer id ,String brand, String model, Double price)
	{
		this.id= id;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public  String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
		
	}
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	

}
