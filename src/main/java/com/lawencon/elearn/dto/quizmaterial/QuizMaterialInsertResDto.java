package com.lawencon.elearn.dto.quizmaterial;

public class QuizMaterialInsertResDto {
	private QuizMaterialInsertDataResDto data;
	private String message;
	public QuizMaterialInsertDataResDto getData() {
		return data;
	}
	public void setData(QuizMaterialInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
