package com.springboot.resumeupload.model;

import java.util.List;

import lombok.Data;

@Data
public class ProfileRequest {

	private String name;
    private String qualification;
    private double gpa;
    private List<String> skills;

}
