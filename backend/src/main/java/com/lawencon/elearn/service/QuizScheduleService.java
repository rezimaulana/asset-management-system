package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertReqDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleInsertResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleListResDto;
import com.lawencon.elearn.dto.quizschedule.QuizScheduleResDto;

public interface QuizScheduleService {
	QuizScheduleListResDto getAllIdMaterial(Long idMaterial);
	QuizScheduleInsertResDto insert(QuizScheduleInsertReqDto data);
	QuizScheduleListResDto getAllIdClassDtl(Long classDtlId);
	QuizScheduleResDto getById(Long id);
}
