package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.LearningSchedule;

public interface LearningScheduleDao extends BaseDao<LearningSchedule>{
	List<LearningSchedule> getAllIdMaterial(Long idMaterial);
	List<LearningSchedule> getAllIdClassHdr(Long classHdrId);
}
