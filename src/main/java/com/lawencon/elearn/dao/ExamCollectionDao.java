package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.ExamCollection;

public interface ExamCollectionDao extends BaseDao<ExamCollection>{
	List<ExamCollection> getAllClsDtlIdScheduleId(long classDtlId, long scheduleId);
}
