package com.hmsapi.hospital_system.repository;

import com.hmsapi.hospital_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Optional<Patient> existsByEmail(String email);
    boolean existsByContactNumber(String contactNumber);

}
