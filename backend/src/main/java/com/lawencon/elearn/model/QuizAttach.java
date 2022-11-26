package com.lawencon.elearn.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quiz_attach")
public class QuizAttach extends BaseModel {
	@ManyToOne
	@JoinColumn(name = "quiz_id", nullable=false)
	private QuizMaterial quizMaterial;
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	public QuizMaterial getQuizMaterial() {
		return quizMaterial;
	}
	public void setQuizMaterial(QuizMaterial quizMaterial) {
		this.quizMaterial = quizMaterial;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
