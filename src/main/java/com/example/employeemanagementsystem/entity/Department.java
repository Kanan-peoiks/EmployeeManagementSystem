package com.example.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
