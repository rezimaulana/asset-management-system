package com.lawencon.elearn.service;

import com.lawencon.elearn.pojo.SendEmailPojo;

public interface JavaMailService {
	void sendEmail(SendEmailPojo createdAccountPojo);
}
