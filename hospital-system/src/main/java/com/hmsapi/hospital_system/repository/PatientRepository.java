package com.hmsapi.hospital_system.repository;

import com.hmsapi.hospital_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    boolean existsByEmail(String email);

    boolean existsByContactNumber(String contactNumber);

    @Query(value = "SELECT * FROM patient p WHERE p.email = :email", nativeQuery = true)
    Optional<Patient> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM patient p WHERE p.contact_number = :phone", nativeQuery = true)
    Optional<Patient> findByPhone(@Param("phone") String phone);

    void deleteByEmail(String email);

}
