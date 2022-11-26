package com.lawencon.elearn.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.model.File;
import com.lawencon.elearn.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private FileDao fileDao;
	@Override
	public Optional<File> getById(final Long id) {
		return fileDao.getById(id);
	}
}
