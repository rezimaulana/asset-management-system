package com.lawencon.elearn.dao;

import java.util.List;
import java.util.Optional;

import com.lawencon.elearn.model.ClassHdr;

public interface ClassHdrDao extends BaseDao<ClassHdr>{
	List<ClassHdr> getAllIdInstr(Long id);
	Optional<ClassHdr> getByIdInstrIdClass(Long idInstr, Long idClass);
}
