package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.EmployeeRequestDto;
import com.example.employeemanagementsystem.dto.EmployeeResponseDto;
import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    //CREATE
    Employee createEmployee(EmployeeRequestDto employeeRequestDto);

    //READ
    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto getById(Long employeeId);

    //UPDATE
    EmployeeResponseDto update(Long employeeId, EmployeeRequestDto employeeRequestDto);

    //DELETE
    void deleteEmployee(Long employeeId); //sadece silsin deye, geriye deyer vermesin


    List<EmployeeResponseDto> findByDepartmentId(Long departmentId);

    List<EmployeeResponseDto> findEmployeeByDepartmentName(String departmentName);
}
