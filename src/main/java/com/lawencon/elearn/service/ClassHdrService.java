package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.classhdr.ClassHdrInsertReqDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrInsertResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrListResDto;
import com.lawencon.elearn.dto.classhdr.ClassHdrResDto;

public interface ClassHdrService {
	ClassHdrResDto getById(Long id);
	ClassHdrListResDto getAll();
	ClassHdrInsertResDto insert(ClassHdrInsertReqDto data);
	ClassHdrListResDto getAllIdInstr(Long id);
	ClassHdrResDto getByIdInstrIdClass(Long idInstr, Long idClass);
}
