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

import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertReqDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialListResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialResDto;
import com.lawencon.elearn.service.LearningMaterialService;

@RestController
@RequestMapping("learning_material")
public class LearningMaterialController {
	
	@Autowired
	private LearningMaterialService learningMaterialService;
	
	@GetMapping("{idClass}")
	public ResponseEntity<LearningMaterialListResDto> getAllIdClass(@PathVariable("idClass") final long idClass) {
		final LearningMaterialListResDto result = learningMaterialService.getAllIdClass(idClass);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LearningMaterialInsertResDto> insert(@RequestBody LearningMaterialInsertReqDto data){
		final LearningMaterialInsertResDto result = learningMaterialService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("id/{idMaterial}")
	public ResponseEntity<LearningMaterialResDto> getById(@PathVariable("idMaterial") final Long id){
		final LearningMaterialResDto result = learningMaterialService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}