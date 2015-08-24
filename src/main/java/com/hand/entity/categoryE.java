package com.hand.entity;

public class categoryE {
	private long film_id;
	private long category_id;
	public long getFilm_id() {
		return film_id;
	}
	public void setFilm_id(long film_id) {
		this.film_id = film_id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "categoryE [film_id=" + film_id + ", category_id=" + category_id + "]";
	}
	
	
}
