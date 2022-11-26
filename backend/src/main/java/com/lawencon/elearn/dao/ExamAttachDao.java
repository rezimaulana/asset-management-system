package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.ExamAttach;

public interface ExamAttachDao extends BaseDao<ExamAttach>{
	List<ExamAttach> getAllIdClass(Long classId);
	List<ExamAttach> getAllIdMaterial(Long materialId);
}
