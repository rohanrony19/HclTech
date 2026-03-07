package com.springboot.leavemanagesystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.leavemanagesystem.model.Employee;
import com.springboot.leavemanagesystem.model.LeaveStatus;
import com.springboot.leavemanagesystem.service.EmployeeService;

@RestController
@RequestMapping("/hr")
public class HrController {

	private final EmployeeService employeeService;

	public HrController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PutMapping("/updateStatus/{id}")
	public ResponseEntity<Employee> updateStatusApproved(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateStatus(1, LeaveStatus.Approved));
	}
	
	@PutMapping("/rejectStatus/{id}")
	public ResponseEntity<Employee> updateStatusReject(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateStatus(2, LeaveStatus.rejected));
	}
	
	@GetMapping("/getAllLeave")
	public ResponseEntity<List<Employee>> getAllLeave(){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.getLeaveDetail());
	}
}
