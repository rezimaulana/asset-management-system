package com.lawencon.elearn.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exam_attach")
public class ExamAttach extends BaseModel {
	@ManyToOne
	@JoinColumn(name = "exam_id", nullable=false)
	private ExamMaterial examMaterial;
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	public ExamMaterial getExamMaterial() {
		return examMaterial;
	}
	public void setExamMaterial(ExamMaterial examMaterial) {
		this.examMaterial = examMaterial;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
