package com.springboot.musicstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.musicstream.model.Tracks;

public interface TracksRepo extends JpaRepository<Tracks, Integer>{

}
