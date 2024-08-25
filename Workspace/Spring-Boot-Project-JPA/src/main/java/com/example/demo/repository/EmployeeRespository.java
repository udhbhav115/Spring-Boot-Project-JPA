package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.enitity.Employee;



public interface EmployeeRespository extends JpaRepository<Employee, Long> {
	
	@Query(value = "select * from employee where role=:role",nativeQuery = true)
	List<Employee> getByRole(@Param("role") String role);
}
