package com.hand.entity;

import java.sql.Date;

public class customer extends IdEntity {
	
	private String first_name;
	private String last_name;
	private String email;
	private Long add_id;
	private Date lastupdate;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	@Override
	public String toString() {
		return "customer [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", add_id="
				+ add_id + ", lastupdate=" + lastupdate + "]";
	}
	
	

}
