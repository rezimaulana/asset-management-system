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

import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertReqDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialListResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialResDto;
import com.lawencon.elearn.service.ExamMaterialService;

@RestController
@RequestMapping("exam_material")
public class ExamMaterialController {
	
	@Autowired
	private ExamMaterialService examMaterialService;
	
	@GetMapping("{idClass}")
	public ResponseEntity<ExamMaterialListResDto> getAllIdClass(@PathVariable("idClass") final long idClass) {
		final ExamMaterialListResDto result = examMaterialService.getAllIdClass(idClass);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ExamMaterialInsertResDto> insert(@RequestBody ExamMaterialInsertReqDto data){
		final ExamMaterialInsertResDto result = examMaterialService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("id/{idMaterial}")
	public ResponseEntity<ExamMaterialResDto> getById(@PathVariable("idMaterial") final Long id){
		final ExamMaterialResDto result = examMaterialService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}

//	@GetMapping("class/{idClass}/material/{idMaterial}/schedule/{idSchedule}")
//	public ResponseEntity<ClassHdrResDto> getByIdStudIdClassIdMaterialIdSchedule(@PathVariable("id") final Long id){
//		final ClassHdrResDto result = classHdrService.getById(id);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//	@GetMapping("class/{idClass}/material/{idMaterial}")
//	public ResponseEntity<ClassHdrListResDto> getByIdStudIdClassIdMaterial() {
//		final ClassHdrListResDto result = classHdrService.getAll();
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//	@GetMapping("class/{idClass}/material/{idMaterial}/schedule/{idSchedule}/score/{id}")
//	public ResponseEntity<ClassHdrResDto> getByIdStudIdClassIdMaterialIdScheduleIdScore(@PathVariable("id") final Long id){
//		final ClassHdrResDto result = classHdrService.getById(id);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}