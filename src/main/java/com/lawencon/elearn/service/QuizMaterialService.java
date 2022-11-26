package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertReqDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialInsertResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialListResDto;
import com.lawencon.elearn.dto.quizmaterial.QuizMaterialResDto;

public interface QuizMaterialService {
	QuizMaterialListResDto getAllIdClass(Long classId);
	QuizMaterialInsertResDto insert(QuizMaterialInsertReqDto data);
	QuizMaterialResDto getById(Long id);
}
