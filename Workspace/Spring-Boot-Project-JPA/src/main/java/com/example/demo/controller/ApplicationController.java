package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeService;
import com.example.demo.enitity.Employee;

@RestController
public class ApplicationController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
	}
}
