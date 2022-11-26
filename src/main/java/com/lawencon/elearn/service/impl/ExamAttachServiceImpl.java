package com.lawencon.elearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.ExamAttachDao;
import com.lawencon.elearn.service.ExamAttachService;

@Service
public class ExamAttachServiceImpl implements ExamAttachService{
	@Autowired
	private ExamAttachDao examAttachDao;
}
