package com.lawencon.elearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearn.dto.user.UserInsertReqDto;
import com.lawencon.elearn.dto.user.UserInsertResDto;
import com.lawencon.elearn.service.UserService;

@RestController
@RequestMapping("register")
public class RegisterController {
	@Autowired
	private UserService userService;
	@PostMapping()
	public ResponseEntity<UserInsertResDto> insert(@RequestBody UserInsertReqDto data){
		final UserInsertResDto result = userService.insertStudent(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
