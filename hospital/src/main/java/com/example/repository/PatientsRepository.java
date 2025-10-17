package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.details.Patients;

public interface PatientsRepository extends JpaRepository<Patients, Integer> {
}
