package com.lawencon.elearn.dto.attendance;

public class AttendanceInsertResDto {
	private AttendanceInsertDataResDto data;
	private String message;
	public AttendanceInsertDataResDto getData() {
		return data;
	}
	public void setData(AttendanceInsertDataResDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
