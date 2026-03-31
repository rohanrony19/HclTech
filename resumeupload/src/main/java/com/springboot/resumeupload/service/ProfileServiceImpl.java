package com.springboot.resumeupload.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.resumeupload.model.Profile;
import com.springboot.resumeupload.model.ProfileRequest;
import com.springboot.resumeupload.model.ProfileResponse;
import com.springboot.resumeupload.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	private final ProfileRepository repo;
	private final FileStorageService storage;
	private final String photosDir;
	private final String resumesDir;
	

	

	public ProfileServiceImpl(ProfileRepository repo, FileStorageService storage,
							@Value("${app.upload.photos-dir:photos}") String photosDir,
							@Value("${app.upload.resumes-dir:resume}") String resumesDir) {
		super();
		this.repo = repo;
		this.storage = storage;
		this.photosDir = photosDir;
		this.resumesDir = resumesDir;
	}

	@Override
	public ProfileResponse createProfile(ProfileRequest req, MultipartFile photo, MultipartFile resume) {

if (photo == null || photo.isEmpty()) throw new IllegalArgumentException("Photo is required");
        if (resume == null || resume.isEmpty()) throw new IllegalArgumentException("Resume is required");
        if (photo.getContentType() == null || !photo.getContentType().startsWith("image/"))
            throw new IllegalArgumentException("Photo must be an image");
        if (resume.getContentType() == null || !resume.getContentType().equals("application/pdf"))
            throw new IllegalArgumentException("Resume must be a PDF");

        // store files and get relative paths
        String photoRel = storage.store(photosDir, photo);   // e.g., photos/uuid_name.jpg
        String resumeRel = storage.store(resumesDir, resume);// e.g., resumes/uuid_name.pdf

        // map request -> entity
        Profile p = new Profile();
        p.setName(req.getName());
        p.setQualification(req.getQualification());
        p.setGpa(req.getGpa());
        p.setSkills(req.getSkills());
        p.setPhotoUpload(photoRel);
        p.setResumeUpload(resumeRel);

        Profile saved = repo.save(p);

        // build public URLs
        String photoUrl = storage.toPublicUrl(photoRel);
        String resumeUrl = storage.toPublicUrl(resumeRel);

        return ProfileResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .qualification(saved.getQualification())
                .gpa(saved.getGpa())
                .skills(saved.getSkills())
                .photoUrl(photoUrl)
                .resumeUrl(resumeUrl)
                .build();

	}

	@Override
	public ProfileResponse getProfile(Long id) {
		Profile p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Profile not found: " + id));
        return ProfileResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .qualification(p.getQualification())
                .gpa(p.getGpa())
                .skills(p.getSkills())
                .photoUrl(storage.toPublicUrl(p.getPhotoUpload()))
                .resumeUrl(storage.toPublicUrl(p.getResumeUpload()))
                .build();

	}

}
