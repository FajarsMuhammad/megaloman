package com.kinumz.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id_sequence", sequenceName = "employee_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_sequence")
    private Long id;

    @Column
    private Long companyId;

    @Column
    private String name;

    @Column
    private Gender gender;

    @Column
    private Integer age;

    @Column
    private String phone;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Department department;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int2", nullable = false)
    private EmployeeStatus status;

}
