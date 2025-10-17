package com.example.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String disease;
    private String doctorassigned;
    private String admissiondate;
    private String dischargedate;

    public Patients() {
    }

    public Patients(Integer id, String name, Integer age, String gender, String disease,
                    String doctorassigned, String admissiondate, String dischargedate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.doctorassigned = doctorassigned;
        this.admissiondate = admissiondate;
        this.dischargedate = dischargedate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDoctorassigned() {
        return doctorassigned;
    }

    public void setDoctorassigned(String doctorassigned) {
        this.doctorassigned = doctorassigned;
    }

    public String getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(String admissiondate) {
        this.admissiondate = admissiondate;
    }

    public String getDischargedate() {
        return dischargedate;
    }

    public void setDischargedate(String dischargedate) {
        this.dischargedate = dischargedate;
    }
}
