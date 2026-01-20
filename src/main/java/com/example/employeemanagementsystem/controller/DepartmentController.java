package com.example.employeemanagementsystem.controller;


import com.example.employeemanagementsystem.dto.DepartmentRequestDto;
import com.example.employeemanagementsystem.dto.DepartmentResponseDto;
import com.example.employeemanagementsystem.service.DepartmentService;
import com.example.employeemanagementsystem.service.imp.DepartmentServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/departments")
@AllArgsConstructor
@Tag(name = "Department")
public class DepartmentController {

    private DepartmentServiceImp departmentServiceImp;

    @PostMapping(path = "/create")
    @Operation(summary = "Create")
    public ResponseEntity<DepartmentResponseDto> create(@RequestBody DepartmentRequestDto departmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentServiceImp.createDepartment(departmentRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getById(@PathVariable Long id) {
        DepartmentResponseDto departmentResponseDto = departmentServiceImp.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponseDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Obtaining user data in the form of a page using Pagination")
    public ResponseEntity<Page<DepartmentResponseDto>> getAll(@ParameterObject
    @PageableDefault(page = 0, size = 5, value = 10,sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<DepartmentResponseDto> responseDtoPage = departmentServiceImp.getAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoPage);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DepartmentResponseDto>updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequestDto departmentRequestDto) {
        DepartmentResponseDto departmentResponseDto = departmentServiceImp.updateDepartment(id, departmentRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> deleteDepartment(@PathVariable Long id) {
        departmentServiceImp.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }






}
