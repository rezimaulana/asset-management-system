package com.lawencon.elearn.dto.quizschedule;

public class QuizScheduleInsertResDto {
	private QuizScheduleInsertDataResDto data;
	private String message;
	public QuizScheduleInsertDataResDto getData() {
		return data;
	}
	public void setData(QuizScheduleInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
