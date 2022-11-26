package com.lawencon.elearn.dto.quizcollection;

public class QuizCollectionInsertResDto {
	private QuizCollectionInsertDataResDto data;
	private String message;
	public QuizCollectionInsertDataResDto getData() {
		return data;
	}
	public void setData(QuizCollectionInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
