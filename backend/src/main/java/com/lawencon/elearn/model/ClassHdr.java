package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class ClassHdr extends BaseModel {
	@Column(name = "class_code", nullable=false, length=10, unique = true)
	private String code;
	@Column(name = "class_subject", nullable=false, length=200)
	private String subject;
	@Column(name = "class_description", nullable=false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "instructor_id", nullable=false)
	private User instructor;
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private File photo;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getInstructor() {
		return instructor;
	}
	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
}
