package com.springboot.track;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicstream.model.Artist;

@RestController
public class TrackController {
	
	@Autowired
	TrackClientImpl track;
	
	@GetMapping("{id}")
	public Artist getById(@PathVariable Integer id) {
		return track.getById(id);
	}
	
	@PostMapping
	public Artist save(@RequestBody Artist artist) {
		return track.save(artist);
	}
	
	@GetMapping
	public List<Artist> getAll(){
		return track.getAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		track.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public Artist putById(@PathVariable Integer id,@RequestBody Artist artist) {
		return track.putById(id, artist);
	}
	
}
