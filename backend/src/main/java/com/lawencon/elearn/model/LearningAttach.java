package com.lawencon.elearn.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="learning_attach")
public class LearningAttach extends BaseModel {
	@ManyToOne
	@JoinColumn(name = "learning_id", nullable=false)
	private LearningMaterial learningMaterial;
	@ManyToOne
	@JoinColumn(name = "file_id", nullable=false)
	private File file;
	public LearningMaterial getLearningMaterial() {
		return learningMaterial;
	}
	public void setLearningMaterial(LearningMaterial learningMaterial) {
		this.learningMaterial = learningMaterial;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
