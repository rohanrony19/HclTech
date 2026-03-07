package com.springboot.musicstream.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.musicstream.exception.PlaylistException;
import com.springboot.musicstream.model.Playlist;
import com.springboot.musicstream.repository.PlaylistRepo;

@Service
public class PlaylistService {

	private final PlaylistRepo playlistRepo;

	public PlaylistService(PlaylistRepo playlistRepo) {
		super();
		this.playlistRepo = playlistRepo;
	}
	
	public Playlist savePlaylist(Playlist play) {
		return playlistRepo.save(play);
	}
	
	public List<Playlist> getAll(){
		return playlistRepo.findAll();
	}
	
	public Playlist getById(Integer id) {
		Playlist p =playlistRepo.findById(id).orElseThrow(() -> new PlaylistException("Playlist Id not found"));
		return p;
	}
	
	public Playlist putById(Integer id, Playlist play) {
		Playlist p = playlistRepo.findById(id).orElseThrow(()->new PlaylistException("Id not found to update playlist"));
		if(p.getId() == id) {
			p.setName(play.getName());
			p.setDescription(play.getDescription());
		}
		return playlistRepo.save(p);
	}
	
	public void deleteById(Integer id) {
		playlistRepo.deleteById(id);
	}
}
