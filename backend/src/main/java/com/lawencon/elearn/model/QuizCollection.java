package com.lawencon.elearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quiz_collection")
public class QuizCollection extends BaseModel {
	@Column(name = "score")
	private Float score;
	@ManyToOne
	@JoinColumn(name = "class_dtl_id", nullable=false)
	private ClassDtl classDtl;
	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable=false)
	private QuizSchedule quizSchedule;
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
	public QuizSchedule getQuizSchedule() {
		return quizSchedule;
	}
	public void setQuizSchedule(QuizSchedule quizSchedule) {
		this.quizSchedule = quizSchedule;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
