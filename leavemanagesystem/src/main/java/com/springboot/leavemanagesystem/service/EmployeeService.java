package com.springboot.leavemanagesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.leavemanagesystem.model.Employee;

import com.springboot.leavemanagesystem.model.LeaveStatus;
import com.springboot.leavemanagesystem.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee applyLeave(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public List<Employee> getLeaveDetail() {
		return employeeRepo.findAll();
	}
	
	public Employee checkStatusById(Integer id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee Id unavailable"));
		return emp;
	}
	
	public Employee updateStatus(Integer id,LeaveStatus status) {
		Employee emp = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee Id unavailable"));
		emp.setStatus(status);
		return employeeRepo.save(emp);
	}
}
