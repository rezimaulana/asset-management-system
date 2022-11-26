package com.lawencon.elearn.dto.learningschedule;

import java.time.LocalDateTime;

public class LearningScheduleDataDto {
	private Long id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Long learningId;
	private String learningCode;
	private String learningSubject;
	private String learningDescription;
	private Integer ver;
	private Boolean isActive;
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Long getLearningId() {
		return learningId;
	}
	public void setLearningId(Long learningId) {
		this.learningId = learningId;
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
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}
}
