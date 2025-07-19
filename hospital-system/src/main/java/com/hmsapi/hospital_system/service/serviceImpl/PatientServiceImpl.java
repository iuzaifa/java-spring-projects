package com.hmsapi.hospital_system.service.serviceImpl;

import com.hmsapi.hospital_system.mapper.PatientMapper;
import com.hmsapi.hospital_system.model.Patient;
import com.hmsapi.hospital_system.repository.PatientRepository;
import com.hmsapi.hospital_system.respose.PatientRequest;
import com.hmsapi.hospital_system.respose.PatientResponse;
import com.hmsapi.hospital_system.service.IPatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;


    // GET ALL PATIENTS
    @Override
    public List<PatientResponse> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::patientToResponse)
                .collect(Collectors.toList());
    }


    // REGISTER A PATIENT
    @Override
    public PatientResponse registerPatientDetails(PatientRequest patientRequest) {
        Patient patient = new Patient();

        Optional<Patient> getByEmail = Optional.ofNullable(patientRepository.existsByEmail(patientRequest.getEmail()).
                orElseThrow(() -> new RuntimeException("ema is exits")));


        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setFatherName(patientRequest.getFatherName());
        patient.setMotherName(patientRequest.getMotherName());
        patient.setGender(patientRequest.getGender());
        patient.setAge(patientRequest.getAge());

        patient.setContactNumber(patientRequest.getContactNumber());
        patient.setAddress(patientRequest.getAddress());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setBloodGroup(patientRequest.getBloodGroup());
        patient.setEmergencyContact(patientRequest.getEmergencyContact());
        patient.setAdmitted(patientRequest.isAdmitted());



        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.patientToResponse(savedPatient);
    }
}
