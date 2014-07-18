package io.crowdcode.scrumr.model;

import javax.persistence.Entity;

@Entity
public class Project extends AbstractEntity {

	private String title;

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
		return "Project [id=" + getId() + ", title=" + title + "]";
	}
	
}
