package com.lawencon.elearn.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearn.model.File;
import com.lawencon.elearn.service.FileService;

@RestController
@RequestMapping("files")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("download/{id}")
    public ResponseEntity<?> download(@PathVariable("id") final Long id) {
        final Optional<File> file = fileService.getById(id);
        final byte[] fileBytes = Base64.getDecoder().decode(file.get().getCode());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=attachment." + file.get().getExt())
                .body(fileBytes);
    }
	
}
