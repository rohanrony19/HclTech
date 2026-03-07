package com.springboot.musicstream.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.musicstream.model.Playlist;
import com.springboot.musicstream.service.PlaylistService;

@RestController
@RequestMapping("/music/platform/v1/playlist")
public class PlaylistController {

	private final PlaylistService playlistService;

	public PlaylistController(PlaylistService playlistService) {
		super();
		this.playlistService = playlistService;
	}

	@PostMapping
	public ResponseEntity<Playlist> savePlaylist(@RequestBody Playlist play) {
		return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.savePlaylist(play));
	}

	@GetMapping
	public ResponseEntity<List<Playlist>> getPlaylist() {
		return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Playlist> getPlaylistById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.getById(id));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Playlist> updatePlaylistById(@PathVariable Integer id, @RequestBody Playlist play) {
		Playlist obj = playlistService.putById(id, play);
		return ResponseEntity.accepted().body(obj);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlaylistById(@PathVariable Integer id) {
		playlistService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
