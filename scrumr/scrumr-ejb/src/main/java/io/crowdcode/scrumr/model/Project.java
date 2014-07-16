package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Project withTitle(String title) {
		setTitle(title);
		return this;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + "]";
	}
	
	

}
