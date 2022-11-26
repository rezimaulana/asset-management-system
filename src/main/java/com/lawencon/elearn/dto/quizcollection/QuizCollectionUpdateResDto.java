package com.lawencon.elearn.dto.quizcollection;

public class QuizCollectionUpdateResDto {
	private QuizCollectionUpdateDataResDto data;
	private String message;
	public QuizCollectionUpdateDataResDto getData() {
		return data;
	}
	public void setData(QuizCollectionUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
