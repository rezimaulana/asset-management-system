package com.lawencon.elearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.QuizAttachDao;
import com.lawencon.elearn.service.QuizAttachService;

@Service
public class QuizAttachServiceImpl implements QuizAttachService{
	@Autowired
	private QuizAttachDao quizAttachDao;
}
