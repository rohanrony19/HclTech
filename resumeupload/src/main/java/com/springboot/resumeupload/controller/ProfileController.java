package com.springboot.resumeupload.controller;

import com.springboot.resumeupload.model.ProfileRequest;
import com.springboot.resumeupload.model.ProfileResponse;
import com.springboot.resumeupload.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService service;
    public ProfileController(ProfileService service) { this.service = service; }

    @Operation(
        summary = "Upload profile with photo & resume",
        description = "Sends multipart/form-data: JSON part named 'profile' (application/json) + file parts 'photo' and 'resume'",
        responses = {
            @ApiResponse(responseCode = "200", description = "Uploaded successfully")
        }
    )
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResponse> uploadProfile(
            @Parameter(
                description = "Profile JSON (application/json part)",
                required = true,
                content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ProfileRequest.class)
                )
            )
            @RequestPart("profile") ProfileRequest profile,

            @Parameter(description = "Photo file (image/*)", required = true)
            @RequestPart("photo") MultipartFile photo,

            @Parameter(description = "Resume file (application/pdf)", required = true)
            @RequestPart("resume") MultipartFile resume
    ) {
        return ResponseEntity.ok(service.createProfile(profile, photo, resume));
    }
}
