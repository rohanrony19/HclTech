package com.springboot.resumeupload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class FileStorageServiceImpl implements FileStorageService{

	private final Path baseDir;
	private final String publicBaseUrl;
	
	
	public FileStorageServiceImpl(
			@Value("${app.upload.base-dir:uploads}") String baseDir,
			@Value("{app.files.public-base-url:http://localhost:8080/files}") String publicBaseUrl) {
		super();
		this.baseDir = Paths.get(baseDir).toAbsolutePath().normalize();
		this.publicBaseUrl = publicBaseUrl != null ? publicBaseUrl.trim() : "";
		try {
			Files.createDirectories(this.baseDir);
		}catch(IOException e) {
			throw new RuntimeException("Could not create base upload directory,", e);
		}
	}

	@Override
	public String store(String subfolder, MultipartFile file) {

try {
            if (file == null || file.isEmpty()) {
                throw new IllegalArgumentException("File is empty");
            }

            String original = StringUtils.cleanPath(Objects.requireNonNullElse(file.getOriginalFilename(), "file"));
            if (original.contains("..")) {
                throw new IllegalArgumentException("Invalid filename");
            }

            // Build target directory
            Path targetDir = baseDir.resolve(subfolder).normalize();
            Files.createDirectories(targetDir);

            // Generate unique file name to avoid collisions
            String storedName = UUID.randomUUID() + "_" + original.replace(" ", "_");
            Path target = targetDir.resolve(storedName).normalize();

            // Save
            file.transferTo(target);

            // Return relative path (subfolder/filename)
            return subfolder + "/" + storedName;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file: " + ex.getMessage(), ex);

        }
	}

	@Override
	public String toPublicUrl(String relativePath) {

		 if (relativePath == null || relativePath.isBlank()) {
		            return null;
		        }
		        return publicBaseUrl + "/" + relativePath;

	}

}
