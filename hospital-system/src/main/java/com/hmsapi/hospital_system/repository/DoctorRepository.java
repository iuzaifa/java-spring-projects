package com.hmsapi.hospital_system.repository;

import com.hmsapi.hospital_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    @Query(value = "SELECT * FROM doctor WHERE email =:email", nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM doctor WHERE contact_number =:contactNumber", nativeQuery = true)
    boolean existsByPhone(String contactNumber);

    Optional<Doctor> findByEmail(String email);
}
