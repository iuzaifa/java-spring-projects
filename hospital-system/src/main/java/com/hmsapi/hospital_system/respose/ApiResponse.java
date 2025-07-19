package com.hmsapi.hospital_system.respose;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ApiResponse<T>{

    private String message;
    private LocalDateTime timestamp;
    private int status;
    private Object metadata;
    private T data;



}
