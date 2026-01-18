package com.example.employeemanagementsystem.service.imp;


import com.example.employeemanagementsystem.dto.EmployeeRequestDto;
import com.example.employeemanagementsystem.dto.EmployeeResponseDto;
import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.example.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.example.employeemanagementsystem.repository.DepartmentRepo;
import com.example.employeemanagementsystem.repository.EmployeeRepo;
import com.example.employeemanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor //konstruktor yaradir
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    @Override
    public Employee createEmployee(EmployeeRequestDto employeeRequestDto) {
        Department department = departmentRepo.findById(employeeRequestDto.getDepartmentId()).orElseThrow(() ->
                new DepartmentNotFoundException("Department not found" +  employeeRequestDto.getDepartmentId()));

        Employee employee = new Employee();
        employee.setFullName(employeeRequestDto.getFullName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setAdress(employeeRequestDto.getAdress());
        employee.setPhoneNumber(employeeRequestDto.getPhoneNumber());
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepo.save(employee);

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(savedEmployee.getId());
        employeeResponseDto.setFullName(savedEmployee.getFullName());
        employeeResponseDto.setEmail(savedEmployee.getEmail());
        employeeResponseDto.setAdress(savedEmployee.getAdress());
        employeeResponseDto.setPhoneNumber(savedEmployee.getPhoneNumber());
        employeeResponseDto.setDepartmentId(department.getId());

        return employee;}


    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepo.findAll().stream()
                .map(emp -> new EmployeeResponseDto(
                        emp.getId(),
                        emp.getFullName(),
                        emp.getEmail(),
                        emp.getAdress(),
                        emp.getPhoneNumber(),
                        emp.getDepartment() != null ? emp.getDepartment().getId() : null
                )).toList();
    }

    @Override
    public EmployeeResponseDto getById(Long employeeId) { //respons olaraq qaytarmaq isteyirikse, entityde id-ni tapmaliyiq
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found" + employeeId));

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFullName(employee.getFullName());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setAdress(employee.getAdress());
        employeeResponseDto.setPhoneNumber(employee.getPhoneNumber());
        employeeResponseDto.setDepartmentId(employee.getDepartment().getId());
        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto update(Long employeeId, EmployeeRequestDto employeeRequestDto) {
        Employee existRepo = employeeRepo.findById(employeeId).orElseThrow(()->
                new EmployeeNotFoundException("Employee not found" + employeeId));

        existRepo.setFullName(employeeRequestDto.getFullName());
        existRepo.setEmail(employeeRequestDto.getEmail());
        existRepo.setAdress(employeeRequestDto.getAdress());
        existRepo.setPhoneNumber(employeeRequestDto.getPhoneNumber());

        Employee updatedEmployee = employeeRepo.save(existRepo);

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId(updatedEmployee.getId());
        employeeResponseDto.setFullName(updatedEmployee.getFullName());
        employeeResponseDto.setEmail(updatedEmployee.getEmail());
        employeeResponseDto.setAdress(updatedEmployee.getAdress());
        employeeResponseDto.setPhoneNumber(updatedEmployee.getPhoneNumber());

        return employeeResponseDto;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if (!employeeRepo.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Employee not found" + employeeId);
        }
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public List<EmployeeResponseDto> findByDepartmentId(Long departmentId) {
        List<Employee> employees = employeeRepo.findByDepartmentId(departmentId);

        if (employees.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found" + departmentId);
        }

        return employees.stream()
                .map(emp -> new EmployeeResponseDto(
                        emp.getId(),
                        emp.getFullName(),
                        emp.getEmail(),
                        emp.getAdress(),
                        emp.getPhoneNumber(),
                        emp.getDepartment().getId()
                )).toList();
    }

    @Override
    public List<EmployeeResponseDto> findEmployeeByDepartmentName(String departmentName) {
            List<Employee> employees = employeeRepo.findEmployeeByDepartmentName(departmentName);

            if (employees.isEmpty()) {
                throw new DepartmentNotFoundException("Department not found" + departmentName);
            }

            return employees.stream()
                    .map(emp -> new EmployeeResponseDto(
                            emp.getId(),
                            emp.getFullName(),
                            emp.getEmail(),
                            emp.getAdress(),
                            emp.getPhoneNumber(),
                            emp.getDepartment() != null ? emp.getDepartment().getId() : null
                    )).toList();
    }
}
