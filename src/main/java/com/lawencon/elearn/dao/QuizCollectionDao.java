package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.QuizCollection;

public interface QuizCollectionDao extends BaseDao<QuizCollection>{
	List<QuizCollection> getAllClsDtlIdScheduleId(long classDtlId, long scheduleId);
}
