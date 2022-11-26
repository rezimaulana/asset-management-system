package com.lawencon.elearn.service;

import java.util.Optional;

import com.lawencon.elearn.model.File;

public interface FileService {
	Optional<File> getById(Long id);
}
