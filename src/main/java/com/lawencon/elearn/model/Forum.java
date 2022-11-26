package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="forums")
public class Forum extends BaseModel{
	@Column(name = "title", nullable=false, length = 200)
	private String title;
	@Column(name = "content", nullable=false)
	private String content;
	@ManyToOne
	@JoinColumn(name = "class_dtl_id", nullable=false)
	private ClassDtl classDtl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ClassDtl getClassDtl() {
		return classDtl;
	}
	public void setClassDtl(ClassDtl classDtl) {
		this.classDtl = classDtl;
	}
}
