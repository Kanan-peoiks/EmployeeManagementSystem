package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    @Query("SELECT e from Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);


    @Query("SELECT e from Employee e WHERE e.department.departmentName = :departmentName")
    List<Employee> findEmployeeByDepartmentName(@Param("departmentName") String departmentName);




}
