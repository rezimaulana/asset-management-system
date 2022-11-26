package com.lawencon.elearn.dao;

import java.util.Optional;

import com.lawencon.elearn.model.User;

public interface UserDao extends BaseDao<User>{
	Optional<User> getByEmail(String email);
}
