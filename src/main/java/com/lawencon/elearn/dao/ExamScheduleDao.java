package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.ExamSchedule;

public interface ExamScheduleDao extends BaseDao<ExamSchedule>{
	List<ExamSchedule> getAllIdMaterial(Long idMaterial);
	List<ExamSchedule> getAllIdClassHdr(Long classHdrId);
}
