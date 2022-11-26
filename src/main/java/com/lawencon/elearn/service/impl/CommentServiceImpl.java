package com.lawencon.elearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.CommentDao;
import com.lawencon.elearn.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
}
