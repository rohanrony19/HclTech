package com.springboot.leavemanagesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.leavemanagesystem.model.Employee;
import com.springboot.leavemanagesystem.model.LeaveStatus;
import com.springboot.leavemanagesystem.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/applyleave")
	public ResponseEntity<Employee> applyLeave(@RequestBody Employee emp){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.applyLeave(emp));
	}
	
	@GetMapping("/getStatus/{id}")
	public ResponseEntity<Employee> getStatusById(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.checkStatusById(id));
	}
	
	
	
	
}
