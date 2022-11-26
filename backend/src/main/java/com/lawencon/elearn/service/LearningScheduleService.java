package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertReqDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleInsertResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleListResDto;
import com.lawencon.elearn.dto.learningschedule.LearningScheduleResDto;

public interface LearningScheduleService {
	LearningScheduleListResDto getAllIdMaterial(Long idMaterial);
	LearningScheduleInsertResDto insert(LearningScheduleInsertReqDto data);
	LearningScheduleListResDto getAllIdClassDtl(Long classDtlId);
	LearningScheduleResDto getById(Long id);
}
