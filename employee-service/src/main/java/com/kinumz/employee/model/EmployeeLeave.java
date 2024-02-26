package com.kinumz.employee.model;

import java.time.LocalDate;

public class EmployeeLeave {

    private Long id;

    private Employee employee;

    LocalDate startDate;

    LocalDate endDate;

    LeaveType leaveType;

    String reason;

}
