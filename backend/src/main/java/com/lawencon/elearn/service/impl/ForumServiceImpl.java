package com.lawencon.elearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.ForumDao;
import com.lawencon.elearn.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService{
	@Autowired
	private ForumDao forumDao;
}
