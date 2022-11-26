package com.lawencon.elearn.dao;

import java.util.Optional;

import com.lawencon.elearn.model.Role;

public interface RoleDao extends BaseDao<Role>{
	Optional<Role> getByCode(String code);
}
