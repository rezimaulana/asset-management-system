package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertReqDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialInsertResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialListResDto;
import com.lawencon.elearn.dto.exammaterial.ExamMaterialResDto;

public interface ExamMaterialService {
	ExamMaterialListResDto getAllIdClass(Long classId);
	ExamMaterialInsertResDto insert(ExamMaterialInsertReqDto data);
	ExamMaterialResDto getById(Long id);
}
