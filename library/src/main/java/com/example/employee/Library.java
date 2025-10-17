package com.example.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Library {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author;
	private String category;
	private Double price;
	private Integer quantity ;
	
	public Library()
	{
		
	}
	
	public Library(Integer id, String title,String author, String category,Double price, Integer quantity)
	{
		this.id = id;
		this.title = title;
		this.author= author;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public Double getPrice() 
	{
		return price;
	}
	
	public void setPrice(Double  price)
	{
		this.price = price;
	}
	
	public Integer getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	

}
