package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exam_collection")
public class ExamCollection extends BaseModel {
	@Column(name = "score")
	private Float score;
	@ManyToOne
	@JoinColumn(name = "class_dtl_id", nullable=false)
	private ClassDtl classDtl;
	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable=false)
	private ExamSchedule examSchedule;
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public ClassDtl getClassDtl() {
		return classDtl;
	}
	public void setClassDtl(ClassDtl classDtl) {
		this.classDtl = classDtl;
	}
	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}
	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
