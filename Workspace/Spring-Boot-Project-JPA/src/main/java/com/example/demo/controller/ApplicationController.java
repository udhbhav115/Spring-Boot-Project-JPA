package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class ApplicationController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add/employee")
	@CacheEvict(value = "employess",allEntries = true)
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/all", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Cacheable("employess")
	public ResponseEntity<List<Employee>> getAllEmployess(){
		return new ResponseEntity<>(employeeService.getAll(),HttpStatus.OK);
	}
	@GetMapping(value = "/get/employes")
	public ResponseEntity<List<Employee>> getAllEmployess(@RequestParam int page,@RequestParam int size){
		List<Employee> employess=employeeService.getPagenationEmployees(page,size);
		return new ResponseEntity<List<Employee>>(employess,HttpStatus.OK);
		
	}
}
