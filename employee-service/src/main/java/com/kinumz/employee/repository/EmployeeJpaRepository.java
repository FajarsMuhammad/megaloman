package com.kinumz.employee.repository;

import com.kinumz.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

}
