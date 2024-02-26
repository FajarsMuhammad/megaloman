package com.kinumz.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "department")
public class Department extends AuditingEntity {

    @Id
    @SequenceGenerator(name = "department_id_sequence", sequenceName = "department_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_sequence")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long companyId;

}
