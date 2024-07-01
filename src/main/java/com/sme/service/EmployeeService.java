package com.sme.service;

import java.util.List;

import com.sme.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee findByEmail(String email);
}
