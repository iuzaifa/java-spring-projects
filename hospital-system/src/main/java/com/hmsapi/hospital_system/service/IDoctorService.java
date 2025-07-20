package com.hmsapi.hospital_system.service;

import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;

import java.util.List;

public interface IDoctorService {

    List<DoctorResponse> getAllDoctors();

    DoctorResponse createDoctor(DoctorRequest doctorRequest);

    DoctorResponse getDoctorById (Long id);

    void deleteDoctorById(Long id);

    DoctorResponse updateDoctorById(Long id, DoctorRequest doctorRequest);

    DoctorResponse getDoctorByEmail(String email, DoctorRequest doctorRequest);


}
