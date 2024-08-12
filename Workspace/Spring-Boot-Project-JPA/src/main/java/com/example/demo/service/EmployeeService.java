package com.example.demo.service;

import java.util.List;

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
	
	public List<Employee> getAll(){
		return employeeRespository.findAll();
	}
}
