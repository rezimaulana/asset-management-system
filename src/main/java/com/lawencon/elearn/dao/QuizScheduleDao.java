package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.QuizSchedule;

public interface QuizScheduleDao extends BaseDao<QuizSchedule>{
	List<QuizSchedule> getAllIdMaterial(Long idMaterial);
	List<QuizSchedule> getAllIdClassHdr(Long classHdrId);
}
