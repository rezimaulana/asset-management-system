package com.lawencon.elearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.LearningAttachDao;
import com.lawencon.elearn.service.LearningAttachService;

@Service
public class LearningAttachServiceImpl implements LearningAttachService{
	@Autowired
	private LearningAttachDao learningAttachDao;
}
