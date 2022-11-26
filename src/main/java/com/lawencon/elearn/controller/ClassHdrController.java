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

import com.lawencon.elearn.dto.classhdr.ClassHdrInsertReqDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrInsertResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrListResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrResDto;
import com.lawencon.elearn.service.ClassHdrService;

@RestController
@RequestMapping("class-hdr")
public class ClassHdrController {
	@Autowired
	private ClassHdrService classHdrService;
	@GetMapping
	public ResponseEntity<ClassHdrListResDto> getAll() {
		final ClassHdrListResDto result = classHdrService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<ClassHdrResDto> getById(@PathVariable("id") final Long id){
		final ClassHdrResDto result = classHdrService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<ClassHdrInsertResDto> insert(@RequestBody ClassHdrInsertReqDto data){
		final ClassHdrInsertResDto result = classHdrService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("instructor/{id}")
	public ResponseEntity<ClassHdrListResDto> getAllIdInstr(@PathVariable("id") final Long id) {
		final ClassHdrListResDto result = classHdrService.getAllIdInstr(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("instructor/{id1}/class/{id2}")
	public ResponseEntity<ClassHdrResDto> getByIdInstr(@PathVariable("id1") final Long id1,
			@PathVariable("id2") final Long id2){
		final ClassHdrResDto result = classHdrService.getByIdInstrIdClass(id1, id2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
