package com.lawencon.elearn.dto.classhdr;

public class ClassHdrInsertResDto {
	private ClassHdrInsertDataResDto data;
	private String message;
	public ClassHdrInsertDataResDto getData() {
		return data;
	}
	public void setData(ClassHdrInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
