package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enitity.Employee;
import com.example.demo.repository.EmployeeRespository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRespository employeeRespository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}
}
