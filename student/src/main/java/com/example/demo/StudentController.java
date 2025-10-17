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
@RequestMapping("/Student")
public class StudentController {
	
	private List<Student> students = new ArrayList<>();
	@PostMapping
	public String savCar(@RequestBody Student s)
	{
		students.add(s);
		return "student added successfully";
	}
	
	@GetMapping
	public List<Student>getallStudents()
	{
		return students;
	}
	
	@GetMapping("/{id}")
	public Student getStudents(@PathVariable Integer id)
	{
		return students.stream()
				.filter(s -> s.getId().equals(id))
				.findFirst()
				.orElse(new Student());

}
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable Integer id, @RequestBody Student updateStudent )
	{
		for (Student students:students)
		{
		students.setId(updateStudent.getId());
			students.SetName(updateStudent.getName());
			students.setCourse(updateStudent.getCourse());
			students.setMarks(updateStudent.getMarks());
			return "student updated successfully";
		}
		return "not found";
	}
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		boolean removed = students.removeIf(c -> c.getId().equals(id));
		if (removed)
		{
			return "deleted successfully";
		}
		return "not found";
	}
	

}
