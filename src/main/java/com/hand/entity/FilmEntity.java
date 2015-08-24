package com.hand.entity;

public class FilmEntity extends IdEntity {
	private long film_id;
	public long getFilm_id() {
		return film_id;
	}
	public void setFilm_id(long film_id) {
		this.film_id = film_id;
	}
	private String title;
	private String description;
	private long language_id;
	public long getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(long language_id) {
		this.language_id = language_id;
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
		return "FilmEntity [film_id=" + film_id + ", title=" + title + ", description=" + description + ", language_id="
				+ language_id + "]";
	}

	
	
	

}
