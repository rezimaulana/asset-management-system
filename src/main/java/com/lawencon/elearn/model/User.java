package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseModel{
	@Column(name = "email", nullable=false)
	private String email;
	@Column(name = "password", nullable=false, unique=true)
	private String password;
	@Column(name = "fullname", nullable=false)
	private String fullname;
	@ManyToOne
	@JoinColumn(name = "role_id", nullable=false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private File photo;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
}
