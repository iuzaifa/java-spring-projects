package com.hmsapi.hospital_system.controller;

import com.hmsapi.hospital_system.response.ApiResponse;
import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;
import com.hmsapi.hospital_system.service.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("hospital/api/doctors")
public class DoctorController {

    private final IDoctorService doctorService;


    @GetMapping("/get/all-doctors")
    public ResponseEntity<ApiResponse<?>> getAllDoctors(){
        String message = "Doctors fetched successfully";
        List<DoctorResponse> doctors = doctorService.getAllDoctors();

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("totalCount", doctors.size());
        metadata.put("page", 1);
        metadata.put("size", doctors.size());

        ApiResponse<List<?>> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                metadata,
                doctors
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/new-doctor")
    public ResponseEntity<ApiResponse<?>> createDoctors(DoctorRequest doctorRequest){
        String message = "Doctors fetched successfully";
        DoctorResponse doctors = doctorService.createDoctor(doctorRequest);
        ApiResponse<DoctorResponse> response = new ApiResponse<>(
                message,
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                null,
                doctors
        );
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
