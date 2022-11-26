package com.lawencon.elearn.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classes_dtl")
public class ClassDtl extends BaseModel {
	@ManyToOne
	@JoinColumn(name = "student_id", nullable=false)
	private User student;
	@ManyToOne
	@JoinColumn(name = "class_id", nullable=false)
	private ClassHdr classHdr;
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public ClassHdr getClassHdr() {
		return classHdr;
	}
	public void setClassHdr(ClassHdr classHdr) {
		this.classHdr = classHdr;
	}
}
