package com.lawencon.elearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionListResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateResDto;
import com.lawencon.elearn.service.ExamCollectionService;

@RestController
@RequestMapping("exam_collection")
public class ExamCollectionController {
	@Autowired
	private ExamCollectionService examCollectionService;
	
	@GetMapping("/class-dtl/{classDtlId}/schedule/{scheduleId}")
	public ResponseEntity<ExamCollectionListResDto> getAllClsDtlIdScheduleId(
			@PathVariable("classDtlId") final long classDtlId,
			@PathVariable("scheduleId") final long scheduleId) {
		final ExamCollectionListResDto result = examCollectionService.getAllClsDtlIdScheduleId(classDtlId, scheduleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ExamCollectionInsertResDto> insert(@RequestBody ExamCollectionInsertReqDto data){
		final ExamCollectionInsertResDto result = examCollectionService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ExamCollectionUpdateResDto> update(@RequestBody ExamCollectionUpdateReqDto data){
		final ExamCollectionUpdateResDto result = examCollectionService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
