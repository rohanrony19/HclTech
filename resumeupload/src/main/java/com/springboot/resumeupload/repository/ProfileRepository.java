package com.springboot.resumeupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.resumeupload.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
