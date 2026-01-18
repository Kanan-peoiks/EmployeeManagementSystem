package com.example.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private Long departmentId;
}
