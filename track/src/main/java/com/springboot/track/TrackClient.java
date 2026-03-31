package com.springboot.track;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.musicstream.model.Artist;


@FeignClient(name = "track1",url = "http://localhost:8080/music/platform/v1/artists")
public interface TrackClient {

	@GetMapping("/{id}")
	Artist getById(@PathVariable("id") Integer id);
	
	@PostMapping
	Artist save(Artist artist);
	
	@GetMapping
	List<Artist> getAll();
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") Integer id);
	
	@PutMapping("/{id}")
	Artist putById(@PathVariable Integer id,@RequestBody Artist artist);
}
