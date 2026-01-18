package com.example.employeemanagementsystem.service.imp;


import com.example.employeemanagementsystem.dto.DepartmentRequestDto;
import com.example.employeemanagementsystem.dto.DepartmentResponseDto;
import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.example.employeemanagementsystem.repository.DepartmentRepo;
import com.example.employeemanagementsystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department();
        department.setDepartmentName(departmentRequestDto.getDepartmentName());
        department.setDepartmentStatus(departmentRequestDto.getDepartmentStatus());

        Department savedDepartment = departmentRepo.save(department);

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();

        department.setId(department.getId());
        department.setDepartmentName(savedDepartment.getDepartmentName());
        department.setDepartmentStatus(savedDepartment.getDepartmentStatus());

        return  departmentResponseDto;
    }

    @Override
    public DepartmentResponseDto getById(Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow(()->
                new DepartmentNotFoundException("Department with id: "+departmentId+" not found"));

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(department.getId());
        departmentResponseDto.setDepartmentName(department.getDepartmentName());
        departmentResponseDto.setDepartmentStatus(department.getDepartmentStatus());

        return  departmentResponseDto;

    }

    @Override
    public Page<DepartmentResponseDto> getAll(Pageable pageable) {
        return departmentRepo.findAll(pageable)
                .map(dep -> new DepartmentResponseDto(
                        dep.getId(),
                        dep.getDepartmentName(),
                        dep.getDepartmentStatus()
                ));
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto) {
        Department existdepartment = departmentRepo.findById(departmentId).orElseThrow(()->
                new DepartmentNotFoundException("Department with id: "+departmentId+" not found"));

        existdepartment.setDepartmentName(departmentRequestDto.getDepartmentName());
        existdepartment.setDepartmentStatus(departmentRequestDto.getDepartmentStatus());
        Department updateddepartment = departmentRepo.save(existdepartment);

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(updateddepartment.getId());
        departmentResponseDto.setDepartmentName(updateddepartment.getDepartmentName());
        departmentResponseDto.setDepartmentStatus(updateddepartment.getDepartmentStatus());

        return  departmentResponseDto;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
    if(!departmentRepo.existsById(departmentId)) {
        throw new DepartmentNotFoundException("Department not found" + departmentId);
    }
    departmentRepo.deleteById(departmentId);
    }
}
