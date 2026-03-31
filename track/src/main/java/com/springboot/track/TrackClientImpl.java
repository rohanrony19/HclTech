package com.springboot.track;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.musicstream.model.Artist;

@Service
public class TrackClientImpl implements TrackClient{

	@Autowired
	TrackClient trackClient;
	
	@Override
	public Artist getById(Integer id) {
		return trackClient.getById(id);
	}

	@Override
	public Artist save(Artist artist) {
		return trackClient.save(artist);
	}

	@Override
	public List<Artist> getAll() {
		return trackClient.getAll();
	}

	@Override
	public void deleteById(Integer id) {
		trackClient.deleteById(id);
		
	}

	@Override
	public Artist putById(Integer id, Artist artist) {
		return trackClient.putById(id, artist);
	}

}
