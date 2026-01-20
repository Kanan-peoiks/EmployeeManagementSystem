package com.example.employeemanagementsystem.controller;


import com.example.employeemanagementsystem.dto.EmployeeRequestDto;
import com.example.employeemanagementsystem.dto.EmployeeResponseDto;
import com.example.employeemanagementsystem.service.EmployeeService;
import com.example.employeemanagementsystem.service.imp.EmployeeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") //locahhost..../api/employees
@Tag(name = "Employee")
public class EmployeeController {

    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create", description = "if the user is not found, it will give a 404 error and will fail with validation")
    @ApiResponses(value = {
            @ApiResponse(description = "If successful ",responseCode = "200"),
            @ApiResponse(description = "If the user is not found, for the ID ",responseCode = "404"),
            @ApiResponse(description = "If the internal method does not work, it is a server error ",responseCode = "500")
    })

    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return ResponseEntity.ok(employeeServiceImp.createEmployee(employeeRequestDto));
    }

    @ApiResponse(description = "Bringing the data of each user ",responseCode = "204")
    @Operation(summary = "Obtaining all user data ")
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeServiceImp.getAllEmployees());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Essentially bringing the user to the ID")
    @ApiResponses(value = {
            @ApiResponse(description = "If the user is found " ,responseCode = "200"),
            @ApiResponse(description = "If the user is not found ",responseCode = "404"),
            @ApiResponse(description = "If the method does not work, ", responseCode = "500")
    })
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeServiceImp.getById(id));
    }

    @PutMapping(path = "/update/{id}")
    @Operation(summary = "Finding and updating based on User ID")
    public ResponseEntity<EmployeeResponseDto> update(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeServiceImp.update(id, employeeRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Long id) {
        employeeServiceImp.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user Id is essentially deleted " + id);
    }

    @GetMapping(path = "/by-department/{id}")
    public ResponseEntity<List<EmployeeResponseDto>> findEmployeeByDepartmentId(@RequestParam Long departmentId) {
        List<EmployeeResponseDto> employeeResponseDto = employeeServiceImp.findByDepartmentId(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);

    }

    @GetMapping(path = "/departmentName")
    public ResponseEntity<List<EmployeeResponseDto>> findEmployeeByDepartmentName(@RequestParam String departmentName) {
        List<EmployeeResponseDto> employeeResponseDto= employeeServiceImp.findEmployeeByDepartmentName(departmentName);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
    }


}
