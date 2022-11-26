package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="learning_material")
public class LearningMaterial extends BaseModel {
	@Column(name = "learning_code", nullable=false, length = 10, unique=true)
	private String code;
	@Column(name = "learning_subject", nullable=false, length = 200)
	private String subject;
	@Column(name = "learning_description", nullable=false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "class_id", nullable=false)
	private ClassHdr classHdr;
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
	public ClassHdr getClassHdr() {
		return classHdr;
	}
	public void setClassHdr(ClassHdr classHdr) {
		this.classHdr = classHdr;
	}
}
