package com.springboot.musicstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.musicstream.model.Playlist;

public interface PlaylistRepo extends JpaRepository<Playlist, Integer>{

}
