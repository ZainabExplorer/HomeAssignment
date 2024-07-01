package com.sme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sme.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

	
}
