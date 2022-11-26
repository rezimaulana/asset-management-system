package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.classdtl.ClassDtlInsertReqDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlInsertResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlListResDto;
import com.lawencon.elearn.dto.classdtl.ClassDtlResDto;

public interface ClassDtlService {
	ClassDtlListResDto getAllIdStudent(Long id);
	ClassDtlInsertResDto insert(ClassDtlInsertReqDto data);
	ClassDtlResDto getByIdStudentIdClass(Long id);
	ClassDtlResDto getById(Long id);
}
