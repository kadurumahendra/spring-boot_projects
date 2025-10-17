package com.example.hospital;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.details.Patients;
import com.example.repository.PatientsRepository;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    private final PatientsRepository repo;

    public PatientsController(PatientsRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public String savepatients(@RequestBody Patients p) {
        repo.save(p);
        return "saved patients successfully";
    }

    @GetMapping
    public List<Patients> getallpatients() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Patients getdetails(@PathVariable Integer id) {
        return repo.findById(id).orElse(new Patients());
    }

    @PutMapping("/{id}")
    public String updatepatients(@PathVariable Integer id, @RequestBody Patients updatepatients) {
        return repo.findById(id).map(p -> {
            p.setName(updatepatients.getName());
            p.setAge(updatepatients.getAge());
            p.setGender(updatepatients.getGender());
            p.setDisease(updatepatients.getDisease());
            repo.save(p);
            return "updated successfully";
        }).orElse("not found");
    }

    @DeleteMapping("/{id}")
    public String deletepatients(@PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "deleted successfully";
        } else {
            return "not found";
        }
    }
}
