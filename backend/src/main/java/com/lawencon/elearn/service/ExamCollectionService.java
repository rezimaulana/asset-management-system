package com.lawencon.elearn.service;

import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionInsertResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionListResDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateReqDto;
import com.lawencon.elearn.dto.examcollection.ExamCollectionUpdateResDto;

public interface ExamCollectionService {
	ExamCollectionInsertResDto insert(ExamCollectionInsertReqDto data);
	ExamCollectionUpdateResDto update(ExamCollectionUpdateReqDto data);
	ExamCollectionListResDto getAllClsDtlIdScheduleId(long classDtlId, long scheduleId);
}
