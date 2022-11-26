package com.lawencon.elearn.dto.quizmaterial;

public class QuizMaterialInsertReqDto {
	private String quizCode;
	private String quizSubject;
	private String quizDescription;
	private Long classId;
	private String fileCode;
	private String fileExt;
	public String getQuizCode() {
		return quizCode;
	}
	public void setQuizCode(String quizCode) {
		this.quizCode = quizCode;
	}
	public String getQuizSubject() {
		return quizSubject;
	}
	public void setQuizSubject(String quizSubject) {
		this.quizSubject = quizSubject;
	}
	public String getQuizDescription() {
		return quizDescription;
	}
	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
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
