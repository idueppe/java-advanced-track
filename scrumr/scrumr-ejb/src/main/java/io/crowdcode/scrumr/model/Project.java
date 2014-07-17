package io.crowdcode.scrumr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project implements Identifiable {

	@Id
	private String id;

	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
