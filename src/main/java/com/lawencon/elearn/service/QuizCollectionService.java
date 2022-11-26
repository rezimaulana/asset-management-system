package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionInsertResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionListResDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateReqDto;
import com.lawencon.elearn.dto.quizcollection.QuizCollectionUpdateResDto;

public interface QuizCollectionService {
	QuizCollectionInsertResDto insert(QuizCollectionInsertReqDto data);
	QuizCollectionUpdateResDto update(QuizCollectionUpdateReqDto data);
	QuizCollectionListResDto getAllClsDtlIdScheduleId(long classDtlId, long scheduleId);
}
