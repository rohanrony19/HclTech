package com.springboot.musicstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicstream.model.Tracks;
import com.springboot.musicstream.repository.TracksRepo;
import com.springboot.musicstream.service.TrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {
	
	private final TrackService trackService;
	
	private final TracksRepo tracksRepo;

	@Autowired
	public TrackController(TrackService trackService, TracksRepo tracksRepo) {
		super();
		this.trackService = trackService;
		this.tracksRepo = tracksRepo;
	}
	
	@PostMapping
	public ResponseEntity<Tracks> saveTracks(@RequestBody Tracks tracks){
		return ResponseEntity.status(HttpStatus.CREATED).body(trackService.saveTrack(tracks));
	}
	
	@GetMapping
	public ResponseEntity<List<Tracks>> getAllTracks(){
		return ResponseEntity.status(HttpStatus.CREATED).body(trackService.getAllTracks());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tracks> getById(@PathVariable Integer id){
		return tracksRepo.findById(id).map(t -> ResponseEntity.ok(t))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tracks> update(@PathVariable Integer id,@RequestBody Tracks track){
		return tracksRepo.findById(id).map(existing -> {
            track.setId(id);
            return ResponseEntity.ok(tracksRepo.save(track));
        }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		tracksRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
