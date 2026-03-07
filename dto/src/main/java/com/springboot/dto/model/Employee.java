//package com.springboot.dto.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.SequenceGenerator;
//import lombok.Data;
//
//@Entity
//@Data
//public class Employee {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq")
//	@SequenceGenerator(
//			name="emp_seq",
//			sequenceName = "seq",
//			initialValue = 1,
//			allocationSize = 50
//			)
//	private Integer id;
//	
//	private String name;
//	private Double salary;
//	private String emailid;
//	private Long phone;
//}
