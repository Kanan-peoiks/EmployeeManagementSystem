package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.DepartmentRequestDto;
import com.example.employeemanagementsystem.dto.DepartmentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DepartmentService {

    //CREATE
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    //READ
    DepartmentResponseDto getById(Long departmentId);

    Page<DepartmentResponseDto> getAll(Pageable pageable);

    //UPDATE
    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);

    //DELETE
    void deleteDepartment(Long departmentId);

}
