package com.lawencon.elearn.dto.examcollection;

public class ExamCollectionInsertReqDto {
	private Long classDtlId;
	private Long examScheduleId;
	private String fileCode;
	private String fileExt;
	public Long getClassDtlId() {
		return classDtlId;
	}
	public void setClassDtlId(Long classDtlId) {
		this.classDtlId = classDtlId;
	}
	public Long getExamScheduleId() {
		return examScheduleId;
	}
	public void setExamScheduleId(Long examScheduleId) {
		this.examScheduleId = examScheduleId;
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
