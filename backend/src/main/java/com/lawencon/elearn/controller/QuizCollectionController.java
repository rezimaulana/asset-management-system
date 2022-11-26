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

import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionListResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateResDto;
import com.lawencon.elearn.service.QuizCollectionService;

@RestController
@RequestMapping("quiz_collection")
public class QuizCollectionController {
	@Autowired
	private QuizCollectionService quizCollectionService;
	
	@GetMapping("/class-dtl/{classDtlId}/schedule/{scheduleId}")
	public ResponseEntity<QuizCollectionListResDto> getAllClsDtlIdScheduleId(
			@PathVariable("classDtlId") final long classDtlId,
			@PathVariable("scheduleId") final long scheduleId) {
		final QuizCollectionListResDto result = quizCollectionService.getAllClsDtlIdScheduleId(classDtlId, scheduleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<QuizCollectionInsertResDto> insert(@RequestBody QuizCollectionInsertReqDto data){
		final QuizCollectionInsertResDto result = quizCollectionService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<QuizCollectionUpdateResDto> update(@RequestBody QuizCollectionUpdateReqDto data){
		final QuizCollectionUpdateResDto result = quizCollectionService.update(data);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
