package com.example.employeemanagementsystem.service.imp;


import com.example.employeemanagementsystem.dto.DepartmentRequestDto;
import com.example.employeemanagementsystem.dto.DepartmentResponseDto;
import com.example.employeemanagementsystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentService departmentService;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        return null;
    }

    @Override
    public DepartmentResponseDto getById(Long departmentId) {
        return null;
    }

    @Override
    public Page<DepartmentResponseDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto) {
        return null;
    }

    @Override
    public void deleteDepartment(Long departmentId) {

    }
}
