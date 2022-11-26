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

import com.lawencon.elearn.dto.user.UserInsertReqDto;
import com.lawencon.elearn.dto.user.UserInsertResDto;
import com.lawencon.elearn.dto.user.UserListResDto;
import com.lawencon.elearn.dto.user.UserResDto;
import com.lawencon.elearn.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<UserListResDto> getAll() {
		final UserListResDto result = userService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<UserInsertResDto> insert(@RequestBody UserInsertReqDto data){
		final UserInsertResDto result = userService.insertInstructor(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserResDto> getById(@PathVariable("id") final Long id){
		final UserResDto result = userService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("profile/{id}")
	public ResponseEntity<UserResDto> getProfile(@PathVariable("id") final Long id){
		final UserResDto result = userService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}

