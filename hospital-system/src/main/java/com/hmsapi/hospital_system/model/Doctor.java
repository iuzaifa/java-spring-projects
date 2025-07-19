package com.hmsapi.hospital_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;
    private String name;
    private String fatherName;
    private String gender;
    private int age;

    private String contactNumber;
    private String specialization;
    private String qualification;
    private int yearsOfExperience;
    private LocalDate joiningDate;
    private boolean available;

    private LocalDateTime createdAt = LocalDateTime.now();



}
