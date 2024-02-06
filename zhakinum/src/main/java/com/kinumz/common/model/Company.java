package com.kinumz.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String npwp;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String postalCode;

}
