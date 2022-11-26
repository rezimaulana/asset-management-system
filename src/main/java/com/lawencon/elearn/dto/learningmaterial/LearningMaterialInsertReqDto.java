package com.lawencon.elearn.dto.learningmaterial;

public class LearningMaterialInsertReqDto {
	private String learningCode;
	private String learningSubject;
	private String learningDescription;
	private Long classId;
	private String fileCode;
	private String fileExt;
	public String getLearningCode() {
		return learningCode;
	}
	public void setLearningCode(String learningCode) {
		this.learningCode = learningCode;
	}
	public String getLearningSubject() {
		return learningSubject;
	}
	public void setLearningSubject(String learningSubject) {
		this.learningSubject = learningSubject;
	}
	public String getLearningDescription() {
		return learningDescription;
	}
	public void setLearningDescription(String learningDescription) {
		this.learningDescription = learningDescription;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
}
