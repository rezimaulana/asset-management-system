package com.lawencon.elearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearn.dto.classdtl.ClassDtlInsertReqDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlInsertResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlListResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlResDto;
import com.lawencon.elearn.service.ClassDtlService;

@RestController
@RequestMapping("class-dtl")
public class ClassDtlController {
	
	@Autowired
	private ClassDtlService classDtlService;
	
	@GetMapping("{id}")
	public ResponseEntity<ClassDtlListResDto> getAllIdStudent(@PathVariable("id") final Long id) {
		final ClassDtlListResDto result = classDtlService.getAllIdStudent(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<ClassDtlInsertResDto> insert(@RequestBody ClassDtlInsertReqDto data){
		final ClassDtlInsertResDto result = classDtlService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	@GetMapping("/dtl/{id}")
	public ResponseEntity<ClassDtlResDto> getByIdStudentIdClass(@PathVariable("id") final Long id){
		final ClassDtlResDto result = classDtlService.getByIdStudentIdClass(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ClassDtlResDto> getById(@PathVariable("id") Long id){
		final ClassDtlResDto result = classDtlService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
