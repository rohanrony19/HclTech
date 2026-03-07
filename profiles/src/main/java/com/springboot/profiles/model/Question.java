package com.springboot.profiles.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	fetch = FetchType.LAZY
	@OneToMany(mappedBy = "question" ,cascade =CascadeType.ALL)
	private List<Answers> answers;
	
	private String title;
	
	private String description;

	public Question() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", answers=" + answers + ", title=" + title + ", description=" + description
				+ "]";
	}

	public Question(List<Answers> answers, String title, String description) {
		super();
		this.answers = answers;
		this.title = title;
		this.description = description;
	}
	
	
}
