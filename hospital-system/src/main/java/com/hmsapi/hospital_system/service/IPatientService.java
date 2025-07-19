package com.hmsapi.hospital_system.service;


import com.hmsapi.hospital_system.respose.PatientRequest;
import com.hmsapi.hospital_system.respose.PatientResponse;

import java.util.List;

public interface IPatientService {


    List<PatientResponse> getAllPatient();

    PatientResponse registerPatientDetails(PatientRequest patientRequest);
}
