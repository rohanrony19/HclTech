package com.springboot.musicstream.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.musicstream.model.Tracks;
import com.springboot.musicstream.repository.TracksRepo;

@Service
public class TrackService {

	private final TracksRepo tracksRepo;
	
	
	public TrackService(TracksRepo tracksRepo) {
		super();
		this.tracksRepo = tracksRepo;
	}
	
	public Tracks saveTrack(Tracks track) {
		return tracksRepo.save(track);
	}
	public List<Tracks> getAllTracks(){
		return tracksRepo.findAll();
	}
}
