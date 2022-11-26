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

import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertReqDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleListResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleResDto;
import com.lawencon.elearn.service.LearningScheduleService;

@RestController
@RequestMapping("learning_schedule")
public class LearningScheduleController {
	@Autowired
	private LearningScheduleService learningScheduleService;
	
	@GetMapping("{idMaterial}")
	public ResponseEntity<LearningScheduleListResDto> getAllIdMaterial(@PathVariable("idMaterial") final long idMaterial) {
		final LearningScheduleListResDto result = learningScheduleService.getAllIdMaterial(idMaterial);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LearningScheduleInsertResDto> insert(@RequestBody LearningScheduleInsertReqDto data){
		final LearningScheduleInsertResDto result = learningScheduleService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("class-dtl/{classDtlId}")
	public ResponseEntity<LearningScheduleListResDto> getAllIdClassDtl(@PathVariable("classDtlId") final long classDtlId) {
		final LearningScheduleListResDto result = learningScheduleService.getAllIdClassDtl(classDtlId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<LearningScheduleResDto> getById(@PathVariable("id") Long id){
		final LearningScheduleResDto result = learningScheduleService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
