package com.springboot.musicstream.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Tracks {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	
//	private String name;
//	
//	private String duration;
//	
//	
//	private Artist artist;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String albumName;
	
	private String releaseDate;
	
	private String duration;
	
	private String genre;
	
	private String description;
	
	private Integer playCount;
	
	private String fileUrl;
	
	private String coverImage;
	
}
