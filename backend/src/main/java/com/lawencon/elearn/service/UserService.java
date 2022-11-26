package com.lawencon.elearn.service;

import java.util.Optional;

import com.lawencon.elearn.dto.user.UserInsertReqDto;
import com.lawencon.elearn.dto.user.UserInsertResDto;
import com.lawencon.elearn.dto.user.UserListResDto;
import com.lawencon.elearn.dto.user.UserResDto;
import com.lawencon.elearn.model.User;

public interface UserService {
	Optional<User> getByEmail(String email);
	UserListResDto getAll();
	UserResDto getById(Long id);
	UserInsertResDto insertInstructor(UserInsertReqDto data);
	UserInsertResDto insertStudent(UserInsertReqDto data);
}
