package com.example.employeemanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employee {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id avtomatik olaraq unikal ve artan
    private Long id;

    @NotNull(message = "Zehmet olmasa xanani doldurdun, bosh saxlamaq olmaz")
    @Size(min = 5, max = 50, message = "Adinizi ve soyadinizi daxil edin")
    @Column(name = "full_name_employess") //nullable = false (eyni isi icra edir = NotNull) / length = 50 (Size)
    private String fullName;

    @Email(message = "Email standartlarina uygun olaraq qeyd edin.")
    @Column(name = "employee_mails", unique = true) //unikal mail
    private String email;

    @Column(name = "employee_adress")
    @NotEmpty(message = "Adress yazilmalidir") //NotEmpyt olarsa " " bele yazilsa qebul edir
    private String adress;

    @Column(name = "employee_phoneNumbers")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$",
    message = "Telefon nomresi standartlarina uygun olaraq qeyd edin.")
    private String phoneNumber;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //coxlu isci olacaq, bir department olacaq
    @JoinColumn(name = "employee_id")
    private Department department;

}
