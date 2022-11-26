package com.lawencon.elearn.dto.classdtl;

public class ClassDtlInsertResDto {
	private ClassDtlDataResDto data;
	private String message;
	public ClassDtlDataResDto getData() {
		return data;
	}
	public void setData(ClassDtlDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
