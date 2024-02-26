package com.kinumz.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @SequenceGenerator(name = "absent_id_sequence", sequenceName = "absent_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "absent_id_sequence")
    private Long id;

    @ToString.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private ZonedDateTime clockIn;

    @Column
    private ZonedDateTime clockOut;

    @Column
    private String location;

    @Column
    private String approvedBy;

    @Column
    private ZonedDateTime approvedDate;


}
