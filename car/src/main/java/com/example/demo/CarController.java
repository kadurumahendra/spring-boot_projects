package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	
	private List <Cars> car = new ArrayList<>();
	
	@PostMapping
	public String saveCar(@RequestBody Cars c)
	{
		car.add(c);
		return"Car details Saved Successfully";
	}
	
	@GetMapping
	public List<Cars>getallBooks()
	{
		return car;
	}
	
	//get all details
	
	@GetMapping("/{id}")
	public Cars getCar(@PathVariable Integer id ) 
	{
		return car.stream()
				.filter(c ->c.getId().equals(id))
				.findFirst()
				.orElse(new Cars(0,"NA","N/A",0.0));
	}	
	
	@PutMapping("/{id}")
	public String updateCar(@PathVariable Integer id, @RequestBody Cars updateCar)
	{
		for (Cars car :car)
			
		{
			if(car.getId().equals(id))
			{
				car.setBrand(updateCar.getBrand());
				car.setModel(updateCar.getModel());
				car.setPrice(updateCar.getPrice());
				return "car updated successfully";
			}
			
		}
		return "not found";
		}
	
	@DeleteMapping("/{id}")
	public String deleteCar(@PathVariable Integer id)
	{
		Boolean removed = car.removeIf(c -> c.getId().equals(id));
		if (removed) {
            return "Book deleted successfully!";
        } else {
            return "Book not found!";
        }
		
	
	}

}
