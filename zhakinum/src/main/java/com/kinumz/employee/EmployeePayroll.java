package com.kinumz.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeePayroll {

    private Long id;

    private Employee employee;

    private  Department department;

    private EmployeeSalary employeeSalary;

    private EmployeeLeave employeeLeave;

    private LocalDate payrollDate;

    private BigDecimal totalAmount;

}
