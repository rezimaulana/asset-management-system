package com.lawencon.elearn.dto.exammaterial;

public class ExamMaterialInsertResDto {
	private ExamMaterialInsertDataResDto data;
	private String message;
	public ExamMaterialInsertDataResDto getData() {
		return data;
	}
	public void setData(ExamMaterialInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
