package com.lawencon.elearn.dto.error;

public class ExceptionDto<T>{
	T message;
	public T getMessage() {
		return message;
	}
	public void setMessage(T message) {
		this.message = message;
	}
}
