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

import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertReqDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleListResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleResDto;
import com.lawencon.elearn.service.QuizScheduleService;

@RestController
@RequestMapping("quiz_schedule")
public class QuizScheduleController {
	@Autowired
	private QuizScheduleService quizScheduleService;
	
	@GetMapping("{idMaterial}")
	public ResponseEntity<QuizScheduleListResDto> getAllIdMaterial(@PathVariable("idMaterial") final long idMaterial) {
		final QuizScheduleListResDto result = quizScheduleService.getAllIdMaterial(idMaterial);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<QuizScheduleInsertResDto> insert(@RequestBody QuizScheduleInsertReqDto data){
		final QuizScheduleInsertResDto result = quizScheduleService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("class-dtl/{classDtlId}")
	public ResponseEntity<QuizScheduleListResDto> getAllIdClassDtl(@PathVariable("classDtlId") final long classDtlId) {
		final QuizScheduleListResDto result = quizScheduleService.getAllIdClassDtl(classDtlId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<QuizScheduleResDto> getById(@PathVariable("id") Long id){
		final QuizScheduleResDto result = quizScheduleService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
