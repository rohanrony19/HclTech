package com.springboot.musicstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.musicstream.model.Artist;

public interface ArtistRepo extends JpaRepository<Artist, Integer>{

}
