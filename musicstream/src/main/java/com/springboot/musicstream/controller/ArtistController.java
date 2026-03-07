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

import com.springboot.musicstream.model.Artist;
import com.springboot.musicstream.repository.ArtistRepo;
import com.springboot.musicstream.service.ArtistService;



@RestController
@RequestMapping("/music/platform/v1/artists")
public class ArtistController {
	
	private final ArtistService artistService;

	private final ArtistRepo artistRepo;
	
	@Autowired
	public ArtistController(ArtistService artistService,ArtistRepo artistRepo) {
		this.artistService = artistService;
		this.artistRepo = artistRepo;
	}
	
	@PostMapping
	public ResponseEntity<Artist> save(@RequestBody Artist artist){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(artistService.save(artist));
	}
	
	@GetMapping
	public ResponseEntity<List<Artist>> getAll(){
		return ResponseEntity.status(HttpStatus.CREATED).body(artistService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artist> getById(@PathVariable Integer id){
		Artist artist = artistRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
		return ResponseEntity.status(HttpStatus.OK).body(artist);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Artist> update(@PathVariable Integer id,
                                         @RequestBody Artist artist) {
 
        return artistRepo.findById(id).map(existing -> {
            artist.setId(id);
            return new ResponseEntity<>(artistService.save(artist), HttpStatus.OK);
        }).orElse(ResponseEntity.notFound().build());
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        artistRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	

}
