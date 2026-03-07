package com.springboot.musicstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.musicstream.model.Artist;
import com.springboot.musicstream.repository.ArtistRepo;

@Service
public class ArtistService {

	private final ArtistRepo artistRepo;

	@Autowired
	public ArtistService(ArtistRepo artistRepo) {
		super();
		this.artistRepo = artistRepo;
	}
	
	public Artist save(Artist artist) {
		return artistRepo.save(artist);
	}
	
	public List<Artist> getAll(){
		return artistRepo.findAll();
	}
	
}
