package com.lawencon.elearn.dto.learningschedule;

public class LearningScheduleInsertResDto {
	private LearningScheduleInsertDataResDto data;
	private String message;
	public LearningScheduleInsertDataResDto getData() {
		return data;
	}
	public void setData(LearningScheduleInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
