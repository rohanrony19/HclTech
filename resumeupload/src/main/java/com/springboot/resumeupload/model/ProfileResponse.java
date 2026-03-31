package com.springboot.resumeupload.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {

	private Long id;
	private String name;
	private String qualification;
	private double gpa;
	private List<String> skills;
	
	private String photoUrl;
	private String resumeUrl;
}
