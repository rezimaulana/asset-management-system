package com.lawencon.elearn.dto.classdtl;

public class ClassDtlDataDto {
	private Long id;
	private Long classesId;
	private String classesCode;
	private String classesSubject;
	private String classesDescription;
	private Long instructorId;
	private String email;
	private String fullname;
	private Integer ver;
	private Boolean isActive;
	private Long fileId;
	
	public String getClassesDescription() {
		return classesDescription;
	}
	public void setClassesDescription(String classesDescription) {
		this.classesDescription = classesDescription;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	public String getClassesCode() {
		return classesCode;
	}
	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}
	public String getClassesSubject() {
		return classesSubject;
	}
	public void setClassesSubject(String classesSubject) {
		this.classesSubject = classesSubject;
	}
	public Long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}
