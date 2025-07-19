package com.hmsapi.hospital_system.cotroller;


import com.hmsapi.hospital_system.respose.ApiResponse;
import com.hmsapi.hospital_system.respose.PatientRequest;
import com.hmsapi.hospital_system.respose.PatientResponse;
import com.hmsapi.hospital_system.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hospital.com/api/patient")
public class PatientController {

    private final IPatientService patientService;






    // GET ALL PATIENTS
    @GetMapping("/get-all-patients")
    public ResponseEntity<ApiResponse<List<PatientResponse>>> getAllPatients (){
        String apiMessage = "Patients fetched successfully";
        List<PatientResponse> patients = patientService.getAllPatient();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("totalCount", patients.size());
        metadata.put("page", 1); // set actual page number if paginated
        metadata.put("size", patients.size());
        ApiResponse<List<PatientResponse>> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                metadata,
                patients
        );
        return ResponseEntity.ok(response);
    }



    // REGISTER A PATIENT
    @PostMapping("/register-patient") //
    public ResponseEntity<ApiResponse<?>> registerPatient(@RequestBody PatientRequest patientRequest){

        String apiMessage = "Patient created successfully";
        PatientResponse patientResponse = patientService.registerPatientDetails(patientRequest);

        ApiResponse<PatientResponse> response = new ApiResponse<>(
                apiMessage,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                patientResponse
        );
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


 }
