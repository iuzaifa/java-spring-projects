package com.hmsapi.hospital_system.dto;

import com.hmsapi.hospital_system.model.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientDTO {


    private String email;
    private String name;
    private String fatherName;
    private String motherName;
    private String gender;
    private int age;

    private String contactNumber;
    private String address;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private String emergencyContact;
    private boolean admitted;

    private LocalDateTime createdAt = LocalDateTime.now();


}
