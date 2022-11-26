package com.lawencon.elearn.dto.examcollection;

public class ExamCollectionInsertResDto {
	private ExamCollectionInsertDataResDto data;
	private String message;
	public ExamCollectionInsertDataResDto getData() {
		return data;
	}
	public void setData(ExamCollectionInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
