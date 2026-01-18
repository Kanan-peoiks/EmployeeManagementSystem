package com.example.employeemanagementsystem.service.imp;


import com.example.employeemanagementsystem.dto.EmployeeRequestDto;
import com.example.employeemanagementsystem.dto.EmployeeResponseDto;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepo;
import com.example.employeemanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor //konstruktor yaradir
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeResponseDto getById(Long employeeId) {
        return null;
    }

    @Override
    public EmployeeResponseDto update(Long employeeId, EmployeeRequestDto employeeRequestDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

    }

    @Override
    public List<EmployeeResponseDto> findByDepartmentId(Long departmentId) {
        return List.of();
    }

    @Override
    public List<EmployeeResponseDto> findEmployeeByDepartmentName(String departmentName) {
        return List.of();
    }
}
