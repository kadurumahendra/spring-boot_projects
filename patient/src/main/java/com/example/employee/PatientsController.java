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
@RequestMapping("/patients")
public class PatientsController {
	
	private final patientsRepository repo;
	
	public PatientsController(patientsRepository repo)
	{
		this.repo = repo;
	}
	
	@PostMapping
	public String savepatient(@RequestBody Patients p)
	{
		repo.save(p);
		return"patients details added successfully";
	}
	
	@GetMapping
	public List <Patients> getallpatients()
	{
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Patients getallpatients(@PathVariable Integer id)
	{
		return repo.findById(id)
				.orElse(new Patients());
	}
	
	@PutMapping("/{id}")
	public String updatepatients(@PathVariable Integer id, @RequestBody Patients updatepatients)
	{
		List <Patients> allpatients = repo.findAll();
		for(Patients p: allpatients)
		{
			if(p.getId().equals(id))
			{
				p.setName(updatepatients.getName());
				p.setAge(updatepatients.getAge());
				p.setGender(updatepatients.getGender());
				p.setDoctorassigned(updatepatients.getDoctorassigned());
				p.setAdmissiondate(updatepatients.getAdmissiondate());
				p.setDischargedate(updatepatients.getDischargedate());
				repo.save(p);
				return "updated successfully";
				
			}
		}
		
		return "not updated";
	}
	
	@DeleteMapping("/{id}")
	public String deletepatients(@PathVariable Integer id)
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
