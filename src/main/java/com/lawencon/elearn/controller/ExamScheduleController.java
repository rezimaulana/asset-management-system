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

import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertReqDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleListResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleResDto;
import com.lawencon.elearn.service.ExamScheduleService;

@RestController
@RequestMapping("exam_schedule")
public class ExamScheduleController {
	@Autowired
	private ExamScheduleService examScheduleService;
	
	@GetMapping("{idMaterial}")
	public ResponseEntity<ExamScheduleListResDto> getAllIdMaterial(@PathVariable("idMaterial") final long idMaterial) {
		final ExamScheduleListResDto result = examScheduleService.getAllIdMaterial(idMaterial);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ExamScheduleInsertResDto> insert(@RequestBody ExamScheduleInsertReqDto data){
		final ExamScheduleInsertResDto result = examScheduleService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("class-dtl/{classDtlId}")
	public ResponseEntity<ExamScheduleListResDto> getAllIdClassDtl(@PathVariable("classDtlId") final long classDtlId) {
		final ExamScheduleListResDto result = examScheduleService.getAllIdClassDtl(classDtlId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ExamScheduleResDto> getById(@PathVariable("id") Long id){
		final ExamScheduleResDto result = examScheduleService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
