package com.lawencon.elearn.dto.quizcollection;

public class QuizCollectionInsertReqDto {
	private Long classDtlId;
	private Long quizScheduleId;
	private String fileCode;
	private String fileExt;
	public Long getClassDtlId() {
		return classDtlId;
	}
	public void setClassDtlId(Long classDtlId) {
		this.classDtlId = classDtlId;
	}
	public Long getQuizScheduleId() {
		return quizScheduleId;
	}
	public void setQuizScheduleId(Long quizScheduleId) {
		this.quizScheduleId = quizScheduleId;
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
