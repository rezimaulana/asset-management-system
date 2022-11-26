package com.lawencon.elearn.dto.learningschedule;

public class LearningScheduleInsertReqDto {
	private String startTime;
	private String endTime;
	private Long learningId;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Long getLearningId() {
		return learningId;
	}
	public void setLearningId(Long learningId) {
		this.learningId = learningId;
	}
}
