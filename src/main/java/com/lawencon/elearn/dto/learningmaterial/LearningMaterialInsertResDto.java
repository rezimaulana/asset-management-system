package com.lawencon.elearn.dto.learningmaterial;

public class LearningMaterialInsertResDto {
	private LearningMaterialInsertDataResDto data;
	private String message;
	public LearningMaterialInsertDataResDto getData() {
		return data;
	}
	public void setData(LearningMaterialInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
