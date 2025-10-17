package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private List<Employee> emp = new ArrayList<>();
	
	// ➕ Add Employee
	@PostMapping
	public String saveEmp(@RequestBody Employee e) {
		emp.add(e);
		return "Employee added successfully!";
	}
	
	// 📋 Get All Employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return emp;
	}
	
	// 🔍 Get Employee by ID
	@GetMapping("/{id}")
	public Employee getEmp(@PathVariable Integer id) {
		return emp.stream()
				.filter(e -> e.getId().equals(id))
				.findFirst()
				.orElse(new Employee(0, "NA", "N/A", 0.0));
	}
	
	// ✏️ Update Employee by id
	@PutMapping("/{id}")
	public String updateEmp(@PathVariable Integer id, @RequestBody Employee updateEmp) {
		for (Employee e : emp) {
			if (e.getId().equals(id)) {
				e.setEmpname(updateEmp.getEmpname());
				e.setDept(updateEmp.getDept());
				e.setSalary(updateEmp.getSalary());
				return "Employee updated successfully!";
			}
		}
		return "Employee not found!";
	}
	
	// ❌ Delete Employee
	@DeleteMapping("/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		boolean removed = emp.removeIf(e -> e.getId().equals(id));
		if (removed) {
			return "Employee deleted successfully!";
		} else {
			return "Employee not found!";
		}
	}
}
