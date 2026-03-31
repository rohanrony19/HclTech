package com.springboot.resumeupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	String store(String subfolder,MultipartFile file);
	
	String toPublicUrl(String relativePath);
}
