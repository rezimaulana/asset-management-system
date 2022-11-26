package com.lawencon.elearn.dto.learningmaterial;

import java.time.LocalDateTime;
import java.util.List;

public class LearningMaterialDataDto {
	private Long id;
	private String learningCode;
	private String learningSubject;
	private String learningDescription;
	private Long classId;
	private String classCode;
	private String classSubject;
	private Long fileId;
	private String fileCode;
	private String fileExt;
	private Integer ver;
	private Boolean isActive;
	private List<Long> fileList;
	private LocalDateTime createdAt;
	
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public List<Long> getFileList() {
		return fileList;
	}
	public void setFileList(List<Long> fileList) {
		this.fileList = fileList;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getClassSubject() {
		return classSubject;
	}
	public void setClassSubject(String classSubject) {
		this.classSubject = classSubject;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
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
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}
