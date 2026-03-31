package com.springboot.resumeupload.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String qualification;
	private double gpa;
	
	@ElementCollection
	private List<String> skills;
	
	private String photoUpload;
	
	private String resumeUpload;
}
