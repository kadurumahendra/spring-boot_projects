package com.example.employee;

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
@RequestMapping("/library")
public class LibraryController {
	
	private final LibraryRepository repo;
	
	public LibraryController(LibraryRepository repo)
	{
		this.repo = repo;
	}
	
	@PostMapping
	public String savelib(@RequestBody Library l)
	{
	    repo.save(l);
	    return "library book details saved successfully";
	}
	
	@GetMapping
	public List <Library> getalllib()
	{
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Library lib(@PathVariable Integer id)
	{
		return repo.findById(id)
				.orElse(new Library());
	}
	
	@PutMapping("/{id}")
	public String updatelib(@PathVariable Integer id, @RequestBody Library updatelib)
	{
		List <Library> allLib = repo.findAll();
		for (Library l : allLib)
		{
			if (l.getId().equals(id))
			{
				l.setTitle(updatelib.getTitle());
				l.setAuthor(updatelib.getAuthor());
				l.setCategory(updatelib.getCategory());
				l.setPrice(updatelib.getPrice());
				l.setQuantity(updatelib.getQuantity());
				repo.save(l);
				return "updated successfully";
			}
		
		}
		return "not found";
	}
	@DeleteMapping("/{id}")
	public String deletelib(@PathVariable Integer id)
	{
		if (repo.existsById(id))
		{
			repo.deleteById(id);
			return "Deleted successfully";
		}
		else
		{
			return "not found the details";
		}
	}

}
