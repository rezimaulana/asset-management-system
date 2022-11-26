package com.lawencon.elearn.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearn.model.ClassDtl;

public interface ClassDtlDao extends BaseDao<ClassDtl>{
	List<ClassDtl> getAllIdStudent(Long id);
	Optional<ClassDtl> getByIdStudentIdClass(Long id);
}
