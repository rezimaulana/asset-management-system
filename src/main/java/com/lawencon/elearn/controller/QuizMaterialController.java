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

import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertReqDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialListResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialResDto;
import com.lawencon.elearn.service.QuizMaterialService;

@RestController
@RequestMapping("quiz_material")
public class QuizMaterialController {
	
	@Autowired
	private QuizMaterialService quizMaterialService;
	
	@GetMapping("{idClass}")
	public ResponseEntity<QuizMaterialListResDto> getAllIdClass(@PathVariable("idClass") final long idClass) {
		final QuizMaterialListResDto result = quizMaterialService.getAllIdClass(idClass);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<QuizMaterialInsertResDto> insert(@RequestBody QuizMaterialInsertReqDto data){
		final QuizMaterialInsertResDto result = quizMaterialService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("id/{idMaterial}")
	public ResponseEntity<QuizMaterialResDto> getById(@PathVariable("idMaterial") final Long id){
		final QuizMaterialResDto result = quizMaterialService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}