package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertReqDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleInsertResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleListResDto;
import com.lawencon.elearn.dto.examschedule.ExamScheduleResDto;

public interface ExamScheduleService {
	ExamScheduleListResDto getAllIdMaterial(Long idMaterial);
	ExamScheduleInsertResDto insert(ExamScheduleInsertReqDto data);
	ExamScheduleListResDto getAllIdClassDtl(Long classDtlId);
	ExamScheduleResDto getById(Long id);
}
