package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertReqDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialInsertResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialListResDto;
import com.lawencon.elearn.dto.learningmaterial.LearningMaterialResDto;

public interface LearningMaterialService {
	LearningMaterialListResDto getAllIdClass(Long classId);
	LearningMaterialInsertResDto insert(LearningMaterialInsertReqDto data);
	LearningMaterialResDto getById(Long id);
}
