package com.lawencon.elearn.dto.attendance;

public class AttendanceUpdateResDto {
	private AttendanceUpdateDataResDto data;
	private String message;
	public AttendanceUpdateDataResDto getData() {
		return data;
	}
	public void setData(AttendanceUpdateDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
