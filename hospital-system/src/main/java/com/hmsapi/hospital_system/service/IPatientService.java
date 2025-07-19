package com.hmsapi.hospital_system.service;


import com.hmsapi.hospital_system.respose.PatientRequest;
import com.hmsapi.hospital_system.respose.PatientResponse;

import java.util.List;

public interface IPatientService {


    List<PatientResponse> getAllPatient();

    PatientResponse registerPatientDetails(PatientRequest patientRequest);

    PatientResponse patientGetByID(Long id);
    PatientResponse patientGetByEmail(String email);
    PatientResponse patientGetByPhone(String phone);

    void deletePatientById(Long id);
    void deletePatientByEmail(String email);

    PatientResponse updatePatientByEmail(String email, PatientRequest patientRequest);
    PatientResponse updatePatientById(Long id, PatientRequest patientRequest);




}
