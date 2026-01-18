package com.example.employeemanagementsystem.entity;

import com.example.employeemanagementsystem.entity.enumeration.DepartmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter //=@Data
@Setter //=@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departmens_Name")
    private String departmentName;

    @Enumerated(EnumType.STRING)
    @Column(name = "department_status")
    private DepartmentStatus departmentStatus;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    //orphanRemoval eger bir department silinse hemin department-e aid hersey silinsin
    private List<Employee> employees;

}
