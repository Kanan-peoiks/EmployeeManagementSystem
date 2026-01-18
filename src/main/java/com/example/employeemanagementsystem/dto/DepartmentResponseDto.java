package com.example.employeemanagementsystem.dto;

import com.example.employeemanagementsystem.entity.enumeration.DepartmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {
    private Long id;
    private String departmentName;
    private DepartmentStatus departmentStatus;
}
