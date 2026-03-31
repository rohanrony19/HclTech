package com.springboot.fileupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tools.jackson.databind.ObjectMapper;


@RestController
public class UserController {

	@PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String f1(@RequestParam("user") String userJson,
					@RequestParam("file") MultipartFile file) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);
		
		String filename = file.getOriginalFilename();
		
		Path folder = Paths.get("upload");
		if(!Files.exists(folder)) {
			Files.createDirectories(folder);
		}
		
		Path path = folder.resolve(filename);
		
		file.transferTo(path);
		
		return "uploaded for " + user.getName();
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile() throws IOException{
		String filePath = "c:/data/test.txt";
		Path path = Paths.get(filePath);
		
		Resource resource = new UrlResource(path.toUri());
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\" " + resource.getFilename() + "\"")
				.body(resource);
				
	}
	
 
}
