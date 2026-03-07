package com.springboot.leavemanagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.leavemanagesystem.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
