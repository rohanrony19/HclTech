package com.springboot.resumeupload.service;


import org.springframework.web.multipart.MultipartFile;

import com.springboot.resumeupload.model.ProfileRequest;
import com.springboot.resumeupload.model.ProfileResponse;


public interface ProfileService {

	ProfileResponse createProfile(ProfileRequest req,MultipartFile photo,MultipartFile resume);
	
	ProfileResponse getProfile(Long id);
	
}
