package com.example.employee;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository repo;

    // Constructor Injection
    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    // POST - Add Employee
    @PostMapping
    public String saveemp(@RequestBody Employee e) {
        repo.save(e);
        return "Employee added successfully!";
    }

    // GET - All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // GET - Employee by ID
    @GetMapping("/{id}")
    public Employee getEmp(@PathVariable Integer id) {
        return repo.findById(id).orElse(new Employee(0, "Not Found", "N/A", 0.0));
    }

    // PUT - Update Employee
    @PutMapping("/{id}")
    public String updateEmp(@PathVariable Integer id, @RequestBody Employee updateEmp) {
        List<Employee> allEmp = repo.findAll();
        for (Employee e : allEmp) {
            if (e.getId().equals(id)) {
                e.setEmpname(updateEmp.getEmpname());
                e.setDept(updateEmp.getDept());
                e.setSalary(updateEmp.getSalary());
                repo.save(e);
                return "Employee updated successfully!";
            }
        }
        return "Employee not found!";
    }

    // DELETE - Remove Employee
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Employee deleted successfully!";
        } else {
            return "Employee not found!";
        }
    }
}
