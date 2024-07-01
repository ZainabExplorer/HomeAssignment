package com.sme.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sme.entity.Employee;
import com.sme.repository.EmployeeRepository;
import com.sme.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

		
		public Employee findByEmail(String email) {
			// TODO Auto-generated method stub
			return employeeRepository.findByEmail(email);
		}

}
