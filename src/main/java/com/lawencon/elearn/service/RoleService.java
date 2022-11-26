package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.role.RoleListResDto;
import com.lawencon.elearn.dto.role.RoleResDto;

public interface RoleService {
	RoleResDto getById(Long id);
	RoleListResDto getAll();
}
